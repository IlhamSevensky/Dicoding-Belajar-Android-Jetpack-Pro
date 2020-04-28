package com.ilham.jpro.secondsubmission.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("title")
    var name: String? = null,
    @SerializedName("overview")
    var desc: String? = null,
    @SerializedName("poster_path")
    var poster: String? = null,
    @SerializedName("backdrop_path")
    var img_preview: String? = null
)