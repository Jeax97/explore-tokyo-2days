package com.exploretokyo.app.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exploretokyo.app.R
import com.exploretokyo.app.ui.theme.IndigoPrimary
import com.exploretokyo.app.ui.theme.SakuraPink
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    var showTitle by remember { mutableStateOf(false) }
    var showSubtitle by remember { mutableStateOf(false) }
    var showDates by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(400)
        showTitle = true
        delay(600)
        showSubtitle = true
        delay(500)
        showDates = true
        delay(1200)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        IndigoPrimary,
                        IndigoPrimary.copy(alpha = 0.85f),
                        IndigoPrimary.copy(alpha = 0.7f)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Background skyline illustration
        Image(
            painter = painterResource(id = R.drawable.ic_tokyo_skyline),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .alpha(0.15f)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            // Cherry blossom emoji
            AnimatedVisibility(
                visible = showTitle,
                enter = fadeIn() + scaleIn()
            ) {
                Text(
                    text = "🌸",
                    fontSize = 48.sp
                )
            }

            // Title
            AnimatedVisibility(
                visible = showTitle,
                enter = fadeIn() + slideInVertically { it / 2 }
            ) {
                Text(
                    text = "Explore\nTokyo",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 42.sp
                )
            }

            // Subtitle
            AnimatedVisibility(
                visible = showSubtitle,
                enter = fadeIn() + slideInVertically { it / 2 }
            ) {
                Text(
                    text = "Your 2-Day Offline Guide",
                    style = MaterialTheme.typography.titleMedium,
                    color = SakuraPink,
                    textAlign = TextAlign.Center
                )
            }

            // Dates
            AnimatedVisibility(
                visible = showDates,
                enter = fadeIn()
            ) {
                Text(
                    text = "March 6–7, 2026",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
