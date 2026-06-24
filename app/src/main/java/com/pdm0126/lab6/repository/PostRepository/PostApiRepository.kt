package com.pdm0126.lab6.repository.PostRepository

import android.util.Log
//import com.pdm0126.lab6.data.api.meals.GetMealDTOResponseDTO
//import com.pdm0126.lab6.data.api.posts.CreatePostRequestDto
import com.pdm0126.lab6.data.api.meals.MealDTO
import com.pdm0126.lab6.data.api.meals.MealResponseDTO
//import com.pdm0126.lab6.data.api.posts.PostDTO
import com.pdm0126.lab6.data.api.meals.toModel
import com.pdm0126.lab6.data.model.Meal
//import com.pdm0126.lab6.data.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlin.collections.map

//import com.pdm0126.api_json_placeholder.BuildConfig


class PostApiRepository(private val client: HttpClient): PostRepository {

    //private val BASE_URL = "${BuildConfig.BASE_URL}posts"

    override suspend fun getPosts(): Result<List<Meal>> {

        return try {
            //intentar peticion
            val response: MealResponseDTO = client.get("").body()

            //success devolvemos lista de posts transformados
            //Result.success(response.map { it.toModel() })
            Result.success(response.meals.map { it.toModel() })

        } catch (e: Exception) {
            //devolver err
            Log.e("PostApiRepository", "Error fetching posts: ${e.message}", e)
            Result.failure(e)
        }

    }

//    override suspend fun createPost(title: String, body: String): Result<Post>{
//        return try {
//
//            //crear el DTOP de peticion API espera recibir
//
//            val request = CreatePostRequestDto(
//                title = title,
//                body = body,
//                userId = 1
//            )
//
//            //Hacer el POST enviando el 'request'
//            val response: PostDTO = client.post("posts"){
//                contentType(ContentType.Application.Json)
//                setBody(request) //pasamos el DTO request
//            }.body()
//
//            Result.success(response.toModel())
//
//        } catch (e: Exception) {
//            Log.e("PostApiRepository", "Error creating post: ${e.message}", e)
//            Result.failure(e)
//        }
//
//    }

}