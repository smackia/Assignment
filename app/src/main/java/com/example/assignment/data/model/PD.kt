package com.example.assignment.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity
@Keep
data class D(
    @SerializedName("data")
    val data: PD,
) : Serializable


@Keep
data class PD(
    @SerializedName("meta")
    val meta: List<Meta>,
    @SerializedName("posts")
    val posts: List<List<Post>>
) : Serializable

@Keep
data class Meta(
    @SerializedName("mentions")
    val mentions: Int,
    @SerializedName("order")
    val order: Int,
    @SerializedName("tag_text")
    val tag_text: String
) : Serializable

@Keep
data class Post(
    @SerializedName("brand")
    val brand: List<Brand>,
    @SerializedName("bucket_status")
    val bucket_status: String,
    @SerializedName("handle")
    val handle: String,
    @SerializedName("interest_id")
    val interest_id: String,
    @SerializedName("is_followed")
    val is_followed: Boolean,
    @SerializedName("is_liked")
    val is_liked: Boolean,
    @SerializedName("is_sponsored")
    val is_sponsored: Int,
    @SerializedName("language")
    val language: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("live_at")
    val live_at: String,
    @SerializedName("max_down_res")
    val max_down_res: String,
    @SerializedName("mentions")
    val mentions: Int,
    @SerializedName("mux_assest_id")
    val mux_assest_id: String,
    @SerializedName("mux_playback_id")
    val mux_playback_id: String,
    @SerializedName("mux_status")
    val mux_status: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("post_id")
    val post_id: String,
    @SerializedName("products")
    val products: List<Any>,
    @SerializedName("profile_pic")
    val profile_pic: String,
    @SerializedName("resh")
    val resh: String,
    @SerializedName("resw")
    val resw: String,
    @SerializedName("tag_text")
    val tag_text: String,
    @SerializedName("tags")
    val tags: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("user_id")
    val user_id: String,
    @SerializedName("views")
    val views: Int
) : Serializable

@Keep
data class Brand(
    @SerializedName("brand_id")
    val brand_id: Int,
    @SerializedName("brand_name")
    val brand_name: String,
    @SerializedName("category")
    val category: Any,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("image_v2")
    val image_v2: String,
    @SerializedName("is_onboarded")
    val is_onboarded: Boolean,
    @SerializedName("meta")
    val meta: Any,
    @SerializedName("website")
    val website: String
) : Serializable