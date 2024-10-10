package dev.vijayakumar.quotes.domain.repository

import dev.vijayakumar.quotes.data.model.Quote
import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse


interface QuoteRepository{

    suspend fun getQuotes(): QuotesResponse
    suspend fun getRandomQuote(): SingleQuoteResponse
    suspend fun getSingleQuote(): SingleQuoteResponse
}