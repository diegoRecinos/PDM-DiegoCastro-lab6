package com.pdm0126.lab6.data.api.meals

import com.pdm0126.lab6.data.model.Meal
import kotlinx.serialization.Serializable

@Serializable
data class MealResponseDTO(
    val meals: List<MealDTO>
)
////@Serializable
//data class GetMealDTOResponseDTO(
//    val page: Int? = null,
//    val results: List<PostDTO>,
//)

//@Serializable
//data class GetMealDTOResponseDTO(
//    val name: String,
//    val results: List<MealDTO>,
//)
//
//fun GetMealDTOResponseDTO.toModel() = GetMealDTOResponseDTO(
//    name = name,
//    results = results.map { it.toModel() }
//)
