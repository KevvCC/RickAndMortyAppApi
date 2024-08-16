package com.example.rickandmortyapp.api

import com.example.rickandmortyapp.data.response.CharacterDataResponse
import com.example.rickandmortyapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null
    ): Response<CharacterDataResponse>
}