package com.example.assignment.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.assignment.data.repository.MainRepository
import com.example.assignment.utils.Constants
import com.example.assignment.utils.Resource
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers


class PostViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun getPostData(context: Context) =
        liveData(Dispatchers.IO, Constants.MAX_TIME) {
            emit(Resource.loading(data = null))
            try {
                emit(
                    Resource.success(
                        data = mainRepository.getPostData(
                            Constants.TOKEN,
                            getPostParam()
                        )
                    )
                )
            } catch (exception: Exception) {
                emit(
                    Resource.error(
                        data = null,
                        message = exception.message
                            ?: "Error Occurred!",
                        exception = exception
                    )
                )
            }
        }

    private fun getPostParam(): JsonObject {
        val jsonObject = JsonObject()
        val jsonArray1 = Gson().toJsonTree(arrayListOf("Gujarati")).asJsonArray
        jsonObject.add("language", jsonArray1)
        jsonObject.add("interest_id", Gson().toJsonTree(arrayListOf(17, 18)).asJsonArray)
        jsonObject.addProperty("brand_id", 9)
        jsonObject.addProperty("force_refresh", true)
        jsonObject.addProperty("start_pos", 0)
        jsonObject.addProperty("end_pos", 1000)
        jsonObject.apply { }
        return jsonObject
    }
}