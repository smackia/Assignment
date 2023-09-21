package com.example.assignment.ui.main.viewmodel

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.assignment.R
import com.example.assignment.data.repository.MainRepository
import com.example.assignment.ui.main.view.activity.MainActivity
import com.example.assignment.utils.Constants
import com.example.assignment.utils.Resource
import com.example.assignment.utils.Status
import com.example.assignment.utils.Utils
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers


class PostViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private fun getPostData() =
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


    fun setupObserversGetPost(mainActivity: MainActivity) {
        getPostData().observeForever {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        mainActivity.hideShimmer()
                        resource.data?.let { response ->
                            try {
                                if (!TextUtils.isEmpty(response.s.toString())) {
                                    if (response.s == 200) {
                                        mainActivity.afterResponse(response)
                                    } else {
                                        Utils.showToast(
                                            mainActivity,
                                            mainActivity.resources.getString(R.string.ops_something_went_wrong)
                                        )
                                    }
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }

                    Status.ERROR -> {
                        mainActivity.hideShimmer()
                        Utils.showToast(
                            mainActivity,
                            mainActivity.resources.getString(R.string.ops_something_went_wrong)
                        )
                    }

                    Status.LOADING -> {
                        mainActivity.showShimmer()
                    }
                }
            }
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