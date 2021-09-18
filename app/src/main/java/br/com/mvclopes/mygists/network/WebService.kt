package br.com.mvclopes.mygists.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


object WebService {
    //TODO adicionar logging interceptor OkHttp

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor { apiInterceptor(it) }.build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val BASE_URL = "https://api.github.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .baseUrl(BASE_URL)
        .build()

    val network: ApiService by lazy { retrofit.create(ApiService::class.java) }
}

interface ApiService{
    @GET("gists/public?per_page=50")
    suspend fun getPublicGists(): String
}

private fun apiInterceptor(it: Interceptor.Chain): Response {
    val originalRequest = it.request()
    val originalHttpUrl = originalRequest.url

    val newHttpUrl = originalHttpUrl.newBuilder()
        .build()

    val newRequest = originalRequest.newBuilder()
        .url(newHttpUrl)
        .build()

    return it.proceed(newRequest)
}