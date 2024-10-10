package dev.vijayakumar.quotes.data.repository


import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse
import dev.vijayakumar.quotes.data.remote.QuoteApiServices
import dev.vijayakumar.quotes.domain.repository.QuoteRepository
import javax.inject.Inject
class QuoteRepositoryImpl @Inject constructor(private val apiService: QuoteApiServices) : QuoteRepository {

    override suspend fun getQuotes(): QuotesResponse {
        val response = apiService.getQuotes()
        if (response.isSuccessful) {
            response.body()?.let {
                return it
            }
        }
        throw Exception("Failed to fetch quotes: ${response.errorBody()?.string()}")
    }

    override suspend fun getRandomQuote(): SingleQuoteResponse {
        return apiService.getRandom()
    }


    override suspend fun getSingleQuote(): SingleQuoteResponse {
        return apiService.getSingleQuote()
        }

}