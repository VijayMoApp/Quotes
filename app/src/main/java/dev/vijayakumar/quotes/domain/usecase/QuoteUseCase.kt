package dev.vijayakumar.quotes.domain.usecase

import dev.vijayakumar.quotes.data.model.Quote
import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.domain.repository.QuoteRepository
import javax.inject.Inject


class QuoteUseCase  @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val response = repository.getQuotes()
        return response.quotes // Ensure this matches the actual response structure
    }


}