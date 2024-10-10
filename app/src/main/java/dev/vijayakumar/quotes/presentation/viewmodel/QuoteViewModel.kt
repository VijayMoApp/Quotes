package dev.vijayakumar.quotes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vijayakumar.quotes.data.model.Quote
import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.domain.usecase.QuoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(private val quoteUseCase: QuoteUseCase) : ViewModel() {

    // Use MutableStateFlow internally and expose as StateFlow
    private val _quoteState = MutableStateFlow<List<Quote>>(emptyList())
    val quoteState: StateFlow<List<Quote>> = _quoteState

    fun getQuotes() {
        viewModelScope.launch {
            try {
                _quoteState.value = quoteUseCase()
            } catch (e: Exception) {
                Timber.tag("Exception VM").d("Error fetching quotes: ${e.message}")
            }
        }
    }
}




