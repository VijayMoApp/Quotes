package dev.vijayakumar.quotes.data.remote

import dev.vijayakumar.quotes.data.model.QuotesResponse
import dev.vijayakumar.quotes.data.model.SingleQuoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiServices {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>



    @GET("/quotes/random")
    suspend fun getRandom(): SingleQuoteResponse


    @GET("/quotes/1")
    suspend fun getSingleQuote(): SingleQuoteResponse
}