package com.example.assignment.data.api

import com.google.gson.JsonObject

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPostData(
        authToken: String?,
        jsonObject: JsonObject
    ) =
        apiService.getPostData(authToken,jsonObject)

}