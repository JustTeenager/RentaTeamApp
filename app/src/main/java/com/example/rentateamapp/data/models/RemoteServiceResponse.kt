package com.example.rentateamapp.data.models

import com.google.gson.annotations.SerializedName

data class RemoteServiceResponse(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val totalItems: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<User>,
    val support: Support
)