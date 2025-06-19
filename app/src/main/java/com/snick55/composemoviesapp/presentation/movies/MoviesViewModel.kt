package com.snick55.composemoviesapp.presentation.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snick55.composemoviesapp.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository
): ViewModel() {

    private val _state = MutableStateFlow(MoviesUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val result = repository.getPagedMovies()
                _state.emit(MoviesUiState(false,result))
            }catch (e: Exception){
                _state.emit(MoviesUiState(false, errorState = ErrorState(true,e.message ?: "")))
            }
        }
    }
}