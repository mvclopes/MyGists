package br.com.mvclopes.mygists.network

import br.com.mvclopes.mygists.model.Gist
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

object WebService {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val BASE_URL = "https://api.github.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val network: ApiService by lazy { retrofit.create(ApiService::class.java) }
}

interface ApiService{
    @GET("gists/public?per_page=1")
    suspend fun getPublicGists(): Gist
}