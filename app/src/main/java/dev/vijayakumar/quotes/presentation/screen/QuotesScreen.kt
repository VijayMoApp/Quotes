package dev.vijayakumar.quotes.presentation.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.vijayakumar.quotes.data.model.Quote
import dev.vijayakumar.quotes.presentation.viewmodel.QuoteViewModel
import timber.log.Timber


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotesScreen (quoteViewModel: QuoteViewModel = hiltViewModel()){

    val allQuotes by quoteViewModel.quoteState.collectAsState()
    Toast.makeText(LocalContext.current, allQuotes.toString(), Toast.LENGTH_SHORT).show()
    LaunchedEffect(Unit) {
        quoteViewModel.getQuotes()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quotes") }
            )
        }
    ) { padding ->
        // Display the list of quotes inside a LazyColumn
        LazyColumn(
                 modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Check if the list is empty
            if (allQuotes.isEmpty()) {
                item {
                    Text(
                        text = "No quotes available.",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            } else {
                // Display each quote using the QuoteItem composable
                items(allQuotes) { quote ->
                    QuoteItem(quote)
                }
            }
        }
    }
}


@Composable
fun QuoteItem(quote: Quote) {
    // Card to display individual quote
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = quote.quote,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "- ${quote.author}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}