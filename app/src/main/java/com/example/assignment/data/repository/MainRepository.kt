package com.example.assignment.data.repository

import com.example.assignment.data.api.ApiHelper
import com.google.gson.JsonObject

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPostData(
        authToken: String?,
        jsonObject: JsonObject
    ) =
        apiHelper.getPostData(authToken, jsonObject)
}
