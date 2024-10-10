package dev.vijayakumar.quotes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vijayakumar.quotes.data.remote.QuoteApiServices
import dev.vijayakumar.quotes.data.repository.QuoteRepositoryImpl
import dev.vijayakumar.quotes.domain.repository.QuoteRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): QuoteApiServices {
        return retrofit.create(QuoteApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideQuoteRepository(apiService: QuoteApiServices): QuoteRepository {
        return QuoteRepositoryImpl(apiService)
    }

}