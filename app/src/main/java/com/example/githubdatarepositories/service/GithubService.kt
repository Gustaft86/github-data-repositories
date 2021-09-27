package com.example.githubdatarepositories.service

import com.example.githubdatarepositories.model.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("/search/repositories?q=language:kotlin&sort=stars")
    fun getListRepositories(@Query("page")page: Int) : Call<Repositories>
}
