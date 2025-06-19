package com.snick55.composemoviesapp.presentation.movies

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.snick55.composemoviesapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesTopBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.movies))
        },
        modifier = modifier,
    )

}