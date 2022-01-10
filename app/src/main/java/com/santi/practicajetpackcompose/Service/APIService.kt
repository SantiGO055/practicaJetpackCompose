package com.santi.practicajetpackcompose.Service

import com.santi.practicajetpackcompose.Model.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun damePerrosPorRaza(@Url url: String): Response<DogResponse>
}
