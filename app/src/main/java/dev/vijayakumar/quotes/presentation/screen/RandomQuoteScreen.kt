package dev.vijayakumar.quotes.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.vijayakumar.quotes.presentation.viewmodel.RandomQuoteViewModel


@Composable
fun RandomScreen(randomQuote: RandomQuoteViewModel = hiltViewModel()) {

    val random by randomQuote.randomQState.collectAsState()

    LaunchedEffect(Unit) {
        randomQuote.getRandomQuotes()
    }

    random?.let { singleQuoteResponse ->
        QuoteContent(singleQuoteResponse)
    } ?: run {
        // Show loading state
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
