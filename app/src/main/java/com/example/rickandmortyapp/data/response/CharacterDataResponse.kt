package com.example.rickandmortyapp.data.response

import com.google.gson.annotations.SerializedName

data class CharacterDataResponse(
    @SerializedName("info") val info: InfoResponse,
    @SerializedName("results") val results: List<CharacterResponse>
)
