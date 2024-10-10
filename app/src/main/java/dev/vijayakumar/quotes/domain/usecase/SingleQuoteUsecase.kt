package dev.vijayakumar.quotes.domain.usecase

import dev.vijayakumar.quotes.data.model.Quote
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse
import dev.vijayakumar.quotes.domain.repository.QuoteRepository
import javax.inject.Inject

class SingleQuoteUsecase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): SingleQuoteResponse {

        return repository.getSingleQuote() // Ensure this matches the actual response structure
    }
}
