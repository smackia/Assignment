package com.example.assignment.utils

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
enum class Status {
    @SerializedName("SUCCESS")
    SUCCESS,
    @SerializedName("ERROR")
    ERROR,
    @SerializedName("LOADING")
    LOADING
}