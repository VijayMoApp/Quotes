package dev.vijayakumar.quotes.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse


@Composable
fun QuoteContent(singleQuoteResponse: SingleQuoteResponse) {
    // Ensure you have the Material3 Theme applied to your app
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Title
            Text(
                text = singleQuoteResponse.author,
                style = MaterialTheme.typography.titleLarge, // Updated for Material3
                modifier = Modifier.padding(top = 40.dp, bottom = 8.dp)
            )



            // Explanation
            Text(
                text = singleQuoteResponse.quote,
                style = MaterialTheme.typography.bodyLarge, // Updated for Material3
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
