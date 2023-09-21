package com.example.assignment.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class GR(
    @SerializedName("success")
    val m: Boolean?,

    @SerializedName("status")
    val s: Int?,

    @SerializedName("data")
    val r: PD?
) : Serializable