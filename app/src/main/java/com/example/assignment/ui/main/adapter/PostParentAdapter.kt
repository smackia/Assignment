package com.example.assignment.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.data.model.Meta
import com.example.assignment.data.model.Post
import com.example.assignment.ui.main.view.activity.MainActivity


class PostParentAdapter(
    metaList: ArrayList<Meta>,
    postList: ArrayList<ArrayList<Post>>,
    private val mainActivity: MainActivity
) :
    RecyclerView.Adapter<PostParentAdapter.MyViewHolder>() {
    private var metaList = ArrayList<Meta>()
    private var postList = ArrayList<ArrayList<Post>>()

    init {
        this.metaList.clear()
        this.metaList.addAll(metaList)
        this.postList.clear()
        this.postList = postList
    }

    fun refreshList(metaList: ArrayList<Meta>, postList: ArrayList<ArrayList<Post>>) {
        this.metaList.clear()
        this.metaList.addAll(metaList)
        this.postList.clear()
        this.postList = postList
        kotlin.run {
            notifyDataSetChanged()
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvPostTag: TextView = view.findViewById(R.id.tv_post_tag)
        var childView: RecyclerView = view.findViewById(R.id.rv_child)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(mainActivity)
            .inflate(R.layout.post_parent_item, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(metaList[position]) {
                tvPostTag.text = "#$tag_text"
                val postChildAdapter = PostChildAdapter(postList[position], mainActivity)
                childView.apply {
                    setHasFixedSize(false)
                    layoutManager =
                        LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = postChildAdapter
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return metaList.size
    }

}