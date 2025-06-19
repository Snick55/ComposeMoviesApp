package com.snick55.composemoviesapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("v1.4/movie")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("notNullFields") notNullFields: List<String> = listOf("id","name","ageRating","countries.name","description","year")
    ): MoviesResponse

}