package com.example.assignment.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    val brand: List<Brand>,
    val bucket_status: String,
    val handle: String,
    val interest_id: String,
    val is_followed: Boolean,
    val is_liked: Boolean,
    val is_sponsored: Int,
    val language: String,
    val likes: Int,
    val live_at: String,
    val max_down_res: String,
    val mentions: Int,
    val mux_assest_id: String,
    val mux_playback_id: String,
    val mux_status: String,
    val order: Int,
    val origin: String,
    val post_id: String,
    val products: List<Any>,
    val profile_pic: String,
    val resh: String,
    val resw: String,
    val tag_text: String,
    val tags: String,
    val text: String,
    val title: String,
    val user_id: String,
    val views: Int
): Serializable

@Keep
data class Brand(
    val brand_id: Int,
    val brand_name: String,
    val category: Any,
    val created_at: String,
    val description: String,
    val id: Int,
    val image: String,
    val image_v2: String,
    val is_onboarded: Boolean,
    val meta: Any,
    val website: String
) : Serializable