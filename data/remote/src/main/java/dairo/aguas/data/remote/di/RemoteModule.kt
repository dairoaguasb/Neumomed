package dairo.aguas.data.remote.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dairo.aguas.data.remote.ApiServices
import dairo.aguas.data.remote.post.PostDatasource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun createRemoteModule(baseUrl: String, debugMode: Boolean) = module {

    single { createService(get()) }

    single { createRetrofit(get(), baseUrl) }

    single { createOkHttpClient(debugMode) }

    single { createMoshiConverterFactory() }

    single { createMoshi() }

    factory { PostDatasource(get(), get()) }
}

fun createService(retrofit: Retrofit): ApiServices {
    return retrofit.create(ApiServices::class.java)
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

fun createOkHttpClient(debugMode: Boolean): OkHttpClient {
    return OkHttpClient.Builder().apply {
        readTimeout(30L, TimeUnit.SECONDS)
        connectTimeout(30L, TimeUnit.SECONDS)
        if (debugMode) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(this)
            }
        }
    }.build()
}

fun createMoshiConverterFactory(): MoshiConverterFactory {
    return MoshiConverterFactory.create()
}

fun createMoshi(): Moshi {
    return Moshi.Builder().build()
}