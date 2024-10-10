package dev.vijayakumar.quotes.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.vijayakumar.quotes.presentation.util.Screen


@Composable
fun MainScreen(){

    val screen = listOf(
        Screen.Home,
        Screen.QOD,
        Screen.Profile,
        Screen.Quotes
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            BottomNavAnimation(screens = screen)
        }
    }
}
