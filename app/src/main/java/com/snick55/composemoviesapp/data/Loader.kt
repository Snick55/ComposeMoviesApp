package com.snick55.composemoviesapp.data

interface Loader<T>{

    suspend fun load(pageIndex: Int,pageSize: Int):List<T>


}