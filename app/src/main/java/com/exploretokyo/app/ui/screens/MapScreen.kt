package com.exploretokyo.app.ui.screens

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.MotionEvent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.exploretokyo.app.data.ItineraryData
import com.exploretokyo.app.data.Location
import com.exploretokyo.app.R
import com.exploretokyo.app.ui.theme.*
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    onActivityClick: (String) -> Unit
) {
    val context = LocalContext.current
    var selectedDay by remember { mutableIntStateOf(0) } // 0 = all, 1 = day1, 2 = day2

    // Configure osmdroid
    LaunchedEffect(Unit) {
        val osmConfig = Configuration.getInstance()
        osmConfig.userAgentValue = "com.exploretokyo.app"
        val osmCacheDir = File(context.cacheDir, "osmdroid")
        osmCacheDir.mkdirs()
        osmConfig.osmdroidBasePath = osmCacheDir
        osmConfig.osmdroidTileCache = File(osmCacheDir, "tiles")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "🗺️ Tokyo Map",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Day filter tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedDay == 0,
                    onClick = { selectedDay = 0 },
                    label = { Text("All") },
                    shape = RoundedCornerShape(20.dp)
                )
                FilterChip(
                    selected = selectedDay == 1,
                    onClick = { selectedDay = 1 },
                    label = { Text("Day 1") },
                    shape = RoundedCornerShape(20.dp)
                )
                FilterChip(
                    selected = selectedDay == 2,
                    onClick = { selectedDay = 2 },
                    label = { Text("Day 2") },
                    shape = RoundedCornerShape(20.dp)
                )
            }

            // Map
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                OfflineMapView(
                    context = context,
                    selectedDay = selectedDay,
                    onMarkerClick = onActivityClick
                )
            }
        }
    }
}

@Composable
private fun OfflineMapView(
    context: Context,
    selectedDay: Int,
    onMarkerClick: (String) -> Unit
) {
    val itinerary = ItineraryData.itinerary
    val day1Activities = itinerary.days[0].activities
    val day2Activities = itinerary.days[1].activities

    AndroidView(
        factory = { ctx ->
            MapView(ctx).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)

                // Disable internet-based tile loading for true offline use
                // The map will show as gray if no cached/bundled tiles
                // But markers and routes still work perfectly
                setUseDataConnection(false)

                // Center on Tokyo
                val tokyoCenter = GeoPoint(35.68, 139.77)
                controller.setZoom(12.5)
                controller.setCenter(tokyoCenter)

                // Prevent map from intercepting parent scroll
                setOnTouchListener { v, event ->
                    when (event.action) {
                        MotionEvent.ACTION_DOWN -> v.parent?.requestDisallowInterceptTouchEvent(true)
                        MotionEvent.ACTION_UP -> v.parent?.requestDisallowInterceptTouchEvent(false)
                    }
                    false
                }
            }
        },
        update = { mapView ->
            mapView.overlays.clear()

            val markersToShow = when (selectedDay) {
                1 -> day1Activities.map { Triple(it.id, it.title, it.location) to 1 }
                2 -> day2Activities.map { Triple(it.id, it.title, it.location) to 2 }
                else -> day1Activities.map { Triple(it.id, it.title, it.location) to 1 } +
                        day2Activities.map { Triple(it.id, it.title, it.location) to 2 }
            }

            val geoPoints = mutableListOf<GeoPoint>()

            markersToShow.forEach { (info, dayNum) ->
                val (id, title, location) = info
                location?.let { loc ->
                    val point = GeoPoint(loc.lat, loc.lng)
                    geoPoints.add(point)

                    val marker = Marker(mapView)
                    marker.position = point
                    marker.title = title
                    marker.snippet = "Day $dayNum · ${loc.name}"
                    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)

                    marker.setOnMarkerClickListener { m, _ ->
                        m.showInfoWindow()
                        onMarkerClick(id)
                        true
                    }

                    mapView.overlays.add(marker)
                }
            }

            // Add route polylines
            val day1Points = if (selectedDay == 0 || selectedDay == 1) {
                day1Activities.mapNotNull { it.location?.let { l -> GeoPoint(l.lat, l.lng) } }
            } else emptyList()

            val day2Points = if (selectedDay == 0 || selectedDay == 2) {
                day2Activities.mapNotNull { it.location?.let { l -> GeoPoint(l.lat, l.lng) } }
            } else emptyList()

            if (day1Points.size > 1) {
                val line = Polyline()
                line.setPoints(day1Points)
                line.outlinePaint.color = android.graphics.Color.parseColor("#1565C0")
                line.outlinePaint.strokeWidth = 6f
                line.outlinePaint.isAntiAlias = true
                mapView.overlays.add(0, line)
            }

            if (day2Points.size > 1) {
                val line = Polyline()
                line.setPoints(day2Points)
                line.outlinePaint.color = android.graphics.Color.parseColor("#D32F2F")
                line.outlinePaint.strokeWidth = 6f
                line.outlinePaint.isAntiAlias = true
                mapView.overlays.add(0, line)
            }

            // Zoom to show all markers
            if (geoPoints.size > 1) {
                val boundingBox = BoundingBox.fromGeoPointsSafe(geoPoints)
                mapView.post {
                    mapView.zoomToBoundingBox(boundingBox, true, 100)
                }
            } else if (geoPoints.size == 1) {
                mapView.controller.setCenter(geoPoints[0])
                mapView.controller.setZoom(15.0)
            }

            mapView.invalidate()
        },
        modifier = Modifier.fillMaxSize()
    )
}
