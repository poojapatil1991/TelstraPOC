package com.example.myapplication.TelstraPOC.module

import com.example.myapplication.TelstraPOC.utils.ApiInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

/*
Creates global Instance of retrofit to call the API
 */
class ApiModule {

    var retrofit: Retrofit? = null
    val base_url = "https://dl.dropboxusercontent.com/"

    // function returns instance of retrofit
    fun provideApiRetrofit(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(provideOkHttpClient())
                .build()
        }
        return retrofit
    }
    // function returns the instance of OkHttpClient
    fun provideOkHttpClient(): OkHttpClient? {
        val builder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(provideHttpLoggingInterceptor())
            builder.networkInterceptors().add(Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.header("Content-Type", "application/json")
            chain.proceed(requestBuilder.build())
        })
        return builder.build()
    }

    // function returns the instance of HttpLoggingInterceptor
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor? {
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    // Function returns the instance of retrofit
    fun provideAllApi(): ApiInterface? {
        return provideApiRetrofit()!!.create(ApiInterface::class.java)
    }

}
