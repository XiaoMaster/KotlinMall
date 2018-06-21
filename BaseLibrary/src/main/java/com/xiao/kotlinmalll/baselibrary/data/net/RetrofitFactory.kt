package com.xiao.kotlinmalll.baselibrary.data.net

import com.xiao.kotlinmalll.baselibrary.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.AbstractExecutorService
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor() {

    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val headerInterceptor: Interceptor

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(Constant.server_address)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()

        headerInterceptor = Interceptor { chain ->
            val request = chain.request()
                    .newBuilder()
                    .header("Content-Type", "application/json")
                    .addHeader("charset", "utf-8")
                    .build()

            chain.proceed(request)
        }
    }

    private fun initClient(): OkHttpClient? {

        return OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(initLogInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    private fun initLogInterceptor(): Interceptor? {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(service: Class<T>): T {

        return retrofit.create(service)
    }
}
