package com.sample.rmdbclient.data.api.model.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>
)