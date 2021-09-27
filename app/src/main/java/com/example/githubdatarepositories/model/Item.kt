package com.example.githubdatarepositories.model

import com.example.githubdatarepositories.model.Owner

data class Item(
    val name: String,
    val description: String,
    val forks_count: Int,
    val stargazers_count: Int,
    var owner: Owner
)
