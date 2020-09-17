package ru.bedsus.core.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.bedsus.core.token.TokenManager
import java.util.concurrent.TimeUnit

class NetworkServiceImpl(
    baseUrl: String,
    private val tokenManager: TokenManager
) : NetworkService {

    private val tokenInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original: Request = chain.request()
            val request = original.newBuilder().apply {
                if (tokenManager.isToken()) {
                    addHeader("Authorization", "Bearer ${tokenManager.accessToken}")
                }
            }.build()
            return chain.proceed(request)
        }
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
        .connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(tokenInterceptor)

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