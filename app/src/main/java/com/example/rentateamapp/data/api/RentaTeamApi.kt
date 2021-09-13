package com.example.rentateamapp.data.api

import com.example.rentateamapp.data.models.RemoteServiceResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RentaTeamApi {
    @GET("users")
    fun getUsers(): Single<RemoteServiceResponse>
}