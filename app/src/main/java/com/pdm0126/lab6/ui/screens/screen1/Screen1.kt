package com.pdm0126.lab6.ui.screens.screen1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun Screen1(
    viewModel: Screen1ViewModel = viewModel()
    , onBack: () -> Unit) {
    Column {
        Row {
            Button(onClick = { viewModel.fetchPosts() }) { Text("GET Posts") }
            //Button(onClick = { viewModel.createPost() }) { Text("POST (Crear)") }
        }

        //load state
        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }

        //error state
        else if (viewModel.errorMessage != null) {
            Text(text = viewModel.errorMessage!!)
        }

        //success state
        else {
            LazyColumn {
                items(viewModel.posts) { post ->

                    post.strMeal?.let { Text(text = it, style = MaterialTheme.typography.titleLarge) }
                    post.strCategory?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }

                    AsyncImage(
                        model = post.strMealThumb,
                        contentDescription = null
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}