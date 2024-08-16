package com.example.rickandmortyapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapp.api.ApiService
import com.example.rickandmortyapp.data.response.CharacterResponse
import com.example.rickandmortyapp.paging.RickMortyPagingSource
import kotlinx.coroutines.flow.Flow

class RickMortyRepository(private val apiService: ApiService) {

    fun getCharacters(searchQuery: String?): Flow<PagingData<CharacterResponse>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { RickMortyPagingSource(apiService, searchQuery) }
        ).flow
    }
}


