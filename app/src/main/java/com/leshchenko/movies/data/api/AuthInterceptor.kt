package com.leshchenko.movies.data.api

import com.leshchenko.movies.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return with(chain) {
            val updatedUrl = request().url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()
            val updatedRequest = request().newBuilder().url(updatedUrl).build()
            proceed(updatedRequest)
        }
    }
}