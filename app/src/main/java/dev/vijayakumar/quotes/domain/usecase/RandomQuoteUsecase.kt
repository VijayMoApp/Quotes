package dev.vijayakumar.quotes.domain.usecase


import dev.vijayakumar.quotes.data.model.SingleQuoteResponse
import dev.vijayakumar.quotes.domain.repository.QuoteRepository
import javax.inject.Inject

class RandomQuoteUsecase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): SingleQuoteResponse {
        return repository.getRandomQuote()
    }

}