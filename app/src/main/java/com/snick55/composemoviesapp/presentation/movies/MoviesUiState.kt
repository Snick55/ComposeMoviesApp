package com.snick55.composemoviesapp.presentation.movies

import androidx.paging.PagingData
import com.snick55.composemoviesapp.data.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviesUiState(
    val isLoading: Boolean = true,
    val movies: Flow<PagingData<Movie>> = emptyFlow(),
    val errorState: ErrorState = ErrorState()
)

data class ErrorState(
    val isError: Boolean = false,
    val errorMessage: String = ""
)