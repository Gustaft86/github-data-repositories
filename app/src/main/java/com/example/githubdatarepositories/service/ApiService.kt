package com.example.githubdatarepositories.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {
    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun <T> githubService(service:Class<T>) : T = retrofit().create(service)
}