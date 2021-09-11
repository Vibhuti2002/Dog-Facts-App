package com.example.facts.api

import com.example.facts.model.DogFacts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FactService{
   // @GET("/api/v1/resources")
    @GET("/facts")
    suspend fun getFacts(@Query("number") number : Int) : Response<DogFacts>
}