package dev.vijayakumar.quotes.data.model

data class QuotesResponse(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)