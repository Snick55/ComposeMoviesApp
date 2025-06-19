package com.snick55.composemoviesapp.presentation.movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    val moviesItems = state.value.movies.collectAsLazyPagingItems()

    Scaffold(modifier = Modifier,
        topBar = { MoviesTopBar(modifier = Modifier) }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(moviesItems.itemCount) { index ->
                Text(text = moviesItems[index]!!.name)
            }

            moviesItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        this@LazyColumn.item {
                            PageLoader(modifier = Modifier)
                        }
                    }
                }
            }
        }

    }


}

@Composable
fun PageLoader(modifier: Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier.align(Alignment.Center))
    }
}
