package com.exploretokyo.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.exploretokyo.app.data.Day
import com.exploretokyo.app.ui.theme.*

@Composable
fun DayCard(
    day: Day,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradientColors = if (day.dayNumber == 1) {
        listOf(ShibuyaBlue, HarajukuPurple, ShinjukuAmber)
    } else {
        listOf(AsakusaRed, SkytreeTeal, OdaibaGreen)
    }

    val illustration = if (day.dayNumber == 1) {
        com.exploretokyo.app.R.drawable.ic_shibuya_crossing
    } else {
        com.exploretokyo.app.R.drawable.ic_sensoji
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box {
            // Illustration
            Image(
                painter = painterResource(id = illustration),
                contentDescription = "Day ${day.dayNumber} illustration",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )

            // Gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.6f)
                            ),
                            startY = 60f
                        )
                    )
            )

            // Day number badge
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.TopEnd),
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
            ) {
                Text(
                    text = "Day ${day.dayNumber}",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            // Date overlay on image
            Text(
                text = day.date,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        // Content below image
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = day.theme,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Area chips
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                day.areas.forEachIndexed { index, area ->
                    val chipColor = gradientColors.getOrElse(index) { gradientColors.first() }
                    SuggestionChip(
                        onClick = { },
                        label = {
                            Text(
                                text = area,
                                style = MaterialTheme.typography.labelMedium,
                                color = chipColor
                            )
                        },
                        shape = RoundedCornerShape(20.dp),
                        border = SuggestionChipDefaults.suggestionChipBorder(
                            borderColor = chipColor.copy(alpha = 0.5f)
                        )
                    )
                }
            }

            // Vibe
            Text(
                text = "✨ ${day.vibe}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Walking level
            Text(
                text = "🚶 ${day.walkingLevel}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Activity count
            Text(
                text = "${day.activities.size} activities planned",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
