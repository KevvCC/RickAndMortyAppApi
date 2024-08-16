package com.example.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapp.api.ApiService
import com.example.rickandmortyapp.data.RickMortyRepository
import com.example.rickandmortyapp.data.response.CharacterResponse
import com.example.rickandmortyapp.paging.RickMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val repository = RickMortyRepository(apiService)

    val listData = Pager(
        PagingConfig(pageSize = 20)
    ) {
        RickMortyPagingSource(apiService, null)
    }.flow.cachedIn(viewModelScope)

    fun getFilteredCharacters(searchQuery: String): Flow<PagingData<CharacterResponse>> {
        return Pager(
            PagingConfig(pageSize = 20)
        ) {
            RickMortyPagingSource(apiService, searchQuery)
        }.flow.cachedIn(viewModelScope)
    }
}