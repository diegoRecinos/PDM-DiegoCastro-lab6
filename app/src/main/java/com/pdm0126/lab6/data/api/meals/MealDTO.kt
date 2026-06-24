package com.pdm0126.lab6.data.api.meals

import com.pdm0126.lab6.data.model.Meal
import kotlinx.serialization.Serializable

@Serializable
data class MealDTO(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)


//mappers
fun MealDTO.toModel() = Meal(
    idMeal = idMeal,
    strMeal = strMeal,
    strCategory = strCategory,
    strArea = strArea,
    strMealThumb = strMealThumb
)

fun Meal.toDTO() = MealDTO(
    idMeal = idMeal,
    strMeal = strMeal,
    strCategory = strCategory,
    strArea = strArea,
    strMealThumb = strMealThumb
)
