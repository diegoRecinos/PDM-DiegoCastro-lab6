package com.pdm0126.lab6.repository.PostRepository

import com.pdm0126.lab6.data.model.Meal
//import com.pdm0126.lab6.data.model.Post

interface PostRepository {

    suspend fun getPosts(): Result<List<Meal>>
    //suspend fun createPost(title: String, body: String): Result<Post>

}