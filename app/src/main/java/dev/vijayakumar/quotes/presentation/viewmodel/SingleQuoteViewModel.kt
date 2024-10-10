package dev.vijayakumar.quotes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vijayakumar.quotes.data.model.Quote
import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse
import dev.vijayakumar.quotes.domain.usecase.QuoteUseCase
import dev.vijayakumar.quotes.domain.usecase.SingleQuoteUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SingleQuoteViewModel @Inject constructor(private val singlequoteUseCase: SingleQuoteUsecase) : ViewModel() {

    private val _singleQState = MutableStateFlow<SingleQuoteResponse?>(null)
    val singleQState: StateFlow<SingleQuoteResponse?> = _singleQState

    fun getSingleQuotes() {
        viewModelScope.launch {
            try {
                _singleQState.value = singlequoteUseCase()
            } catch (e: Exception) {
                Timber.tag("Exception VM").d(e.message.toString())
                // Optionally show a user-friendly error message or state update
            }
        }
    }
}




