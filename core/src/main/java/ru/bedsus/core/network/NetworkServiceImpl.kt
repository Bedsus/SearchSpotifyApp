package ru.bedsus.core.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkServiceImpl(baseUrl: String) : NetworkService {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
        .connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)

    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        .baseUrl(baseUrl)

    private val retrofit: Retrofit = retrofitBuilder.client(httpClientBuilder.build())
        .build()

    override fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    private companion object {
        const val READ_TIMEOUT_SEC = 30L
        const val CONNECT_TIMEOUT_SEC = 10L
    }
}