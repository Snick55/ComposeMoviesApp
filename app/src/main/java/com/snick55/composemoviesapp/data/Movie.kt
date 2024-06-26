package com.snick55.composemoviesapp.data

data class Movie(
    val ageRating: Int,
    val countries: List<String>,
    val description: String,
    val id: Int,
    val name: String,
    val poster: String,
    val rating: Double,
    val shortDescription: String,
    val year: Int
)


fun Doc.toMovie() = Movie(
    ageRating = ageRating,
    countries = countries.map {
        it.name
    },
    description = description,
    id = id,
    name = name,
    poster = poster?.url ?: "",
    rating = rating.imdb,
    shortDescription = shortDescription ?: "",
    year = year
)