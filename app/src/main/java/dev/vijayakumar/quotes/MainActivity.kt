package dev.vijayakumar.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dev.vijayakumar.quotes.presentation.screen.MainScreen
import dev.vijayakumar.quotes.presentation.screen.QuotesScreen
import dev.vijayakumar.quotes.presentation.screen.RandomScreen
import dev.vijayakumar.quotes.presentation.screen.SingleQuoteScreen
import dev.vijayakumar.quotes.ui.theme.QuotesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesTheme {
                MainScreen()
            }
        }
    }
}
