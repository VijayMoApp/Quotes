package dev.vijayakumar.quotes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse
import dev.vijayakumar.quotes.domain.usecase.RandomQuoteUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RandomQuoteViewModel @Inject constructor(private val randomQuoteUseCase: RandomQuoteUsecase) : ViewModel() {

    private val _randomQState = MutableStateFlow<SingleQuoteResponse?>(null)
    val randomQState: StateFlow<SingleQuoteResponse?> = _randomQState


    fun getRandomQuotes() {
        viewModelScope.launch {
            try {
                _randomQState.value = randomQuoteUseCase()
            } catch (e: Exception) {
                Timber.tag("Exception VM").d(e.message.toString())
                // Optionally show a user-friendly error message or state update
            }
        }
    }

}
