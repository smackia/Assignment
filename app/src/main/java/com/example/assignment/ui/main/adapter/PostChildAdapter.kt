package com.example.assignment.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.data.model.Post
import com.example.assignment.ui.main.view.activity.MainActivity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily


class PostChildAdapter(list: MutableList<Post>, private val mainActivity: MainActivity) :
    RecyclerView.Adapter<PostChildAdapter.MyViewHolder>() {

    private var showList = ArrayList<Post>()


    init {
        showList.clear()
        showList.addAll(list)

    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivThumbnail: ShapeableImageView = view.findViewById(R.id.iv_thumbnail)
        var ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tvName: TextView = view.findViewById(R.id.tv_name)
        var tvDes: TextView = view.findViewById(R.id.tv_des)
        var tvDay: TextView = view.findViewById(R.id.tv_day)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(mainActivity)
            .inflate(R.layout.child_item, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(showList[position]) {
                setImage(
                    ivThumbnail,
                    mainActivity.resources.getDimension(R.dimen.dp10),
                    mux_playback_id,
                    false
                )
                setImage(
                    ivProfile,
                    mainActivity.resources.getDimension(R.dimen.dp5),
                    profile_pic,
                    true
                )
                tvName.text = handle
                tvDes.text = title
                tvDay.text = "20 days ago"
            }
        }
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    private fun setImage(
        ivImage: ShapeableImageView,
        dimension: Float,
        imgUrl: String,
        isCompleteUrl: Boolean
    ) {
        var imageUrl = "https://image.mux.com/$imgUrl/thumbnail.png"
        if (isCompleteUrl) {
            imageUrl = imgUrl
        }
        ivImage.shapeAppearanceModel = ivImage.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(
                CornerFamily.ROUNDED,
                dimension
            )
            .build()

        Glide.with(mainActivity).load(imageUrl).centerCrop()
            .placeholder(
                ContextCompat.getDrawable(
                    mainActivity,
                    R.drawable.ic_c_place_holder
                )
            ).into(ivImage)
    }

}