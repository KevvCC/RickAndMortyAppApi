package com.example.rickandmortyapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.api.ApiService
import com.example.rickandmortyapp.data.response.CharacterResponse

class RickMortyPagingSource(
    private val apiService: ApiService,
    private val searchQuery: String?
) : PagingSource<Int, CharacterResponse>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterResponse>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResponse> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getCharacters(currentPage)
            val data = response.body()?.results ?: emptyList()
            val filteredData = if (searchQuery.isNullOrEmpty()) data else {
                data.filter { it.name.contains(searchQuery, ignoreCase = true) }
            }

            LoadResult.Page(
                data = filteredData,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (filteredData.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}