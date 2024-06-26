package com.snick55.composemoviesapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface MoviesRepository {

    fun getPagedMovies(): Flow<PagingData<Movie>>

    class Base @Inject constructor(
        private val moviesApi: MoviesService,
        private val ioDispatcher: CoroutineDispatcher,
        private val errorHandler: ErrorHandler
    ): MoviesRepository{

        override fun getPagedMovies(): Flow<PagingData<Movie>> {
            val loader = object : Loader<Doc> {
                override suspend fun load(pageIndex: Int, pageSize: Int): List<Doc> {
                    return getMovies(pageIndex, pageSize)
                }
            }
            return Pager(
                config = PagingConfig(
                    pageSize = PAGE_SIZE,
                    enablePlaceholders = false,
                    initialLoadSize = PAGE_SIZE
                ),
                pagingSourceFactory = { MoviesPagingSource(loader, errorHandler) }
            ).flow.map {
               it.map {moviesDTO->
                   moviesDTO.toMovie()
               }
            }

        }

        private suspend fun getMovies(pageIndex: Int, pageSize: Int): List<Doc> =
            withContext(ioDispatcher) {
                val moviesResponse = moviesApi.getMovies(pageIndex, pageSize)
                return@withContext moviesResponse.docs
            }


        private companion object{
            private const val PAGE_SIZE = 20
        }
    }
}


