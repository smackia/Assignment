package com.example.assignment.data.api

import com.example.assignment.data.model.GR
import com.google.gson.JsonObject
import retrofit2.http.*

interface ApiService {

    @POST("v1/homepage/trendingpostsgroupedv3/")
    suspend fun getPostData(
        @Header("TOKEN") authToken: String?,
        @Body jsonObject: JsonObject
    ): GR

}