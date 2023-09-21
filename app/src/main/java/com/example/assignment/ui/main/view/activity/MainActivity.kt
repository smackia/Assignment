package com.example.assignment.ui.main.view.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.example.assignment.data.api.ApiHelper
import com.example.assignment.data.api.RetrofitBuilder
import com.example.assignment.data.model.GR
import com.example.assignment.data.model.Meta
import com.example.assignment.data.model.PD
import com.example.assignment.data.model.Post
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.ui.base.ViewModelFactory
import com.example.assignment.ui.main.adapter.PostParentAdapter
import com.example.assignment.ui.main.viewmodel.PostViewModel
import com.example.assignment.utils.Status
import com.example.assignment.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var vmPost: PostViewModel
    private lateinit var postParentAdapter: PostParentAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupUI()
    }

    private fun setupViewModel() {
        vmPost =
            ViewModelProvider(
                this,
                ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
            )[PostViewModel::class.java]
    }


    private fun setupUI() {
        intiRecyclerView()
        setupObserversGetPost()
    }

    private fun setupObserversGetPost() {
        vmPost.getPostData(this).observe(this) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideShimmer()
                        resource.data?.let { response ->
                            try {
                                if (!TextUtils.isEmpty(response.s.toString())) {
                                    if (response.s == 200) {
                                        afterResponse(response)
                                    } else {
                                        Utils.showToast(
                                            this,
                                            resources.getString(R.string.ops_something_went_wrong)
                                        )
                                    }
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }

                    Status.ERROR -> {
                        hideShimmer()
                        Utils.showToast(
                            this,
                            resources.getString(R.string.ops_something_went_wrong)
                        )
                    }

                    Status.LOADING -> {
                        showShimmer()
                    }
                }
            }
        }
    }

    private fun showShimmer() {
        binding.rvTransaction.visibility = View.GONE
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.shimmerLayout.startShimmerAnimation()
    }

    private fun hideShimmer() {
        binding.rvTransaction.visibility = View.VISIBLE
        binding.shimmerLayout.visibility = View.GONE
        binding.shimmerLayout.stopShimmerAnimation()
    }

    private fun afterResponse(response: GR) {
        if (response.r != null) {
            val list: PD? = Gson().fromJson(
                Gson().toJson(response.r), object : TypeToken<PD?>() {}.type
            )
            if (list != null) {
                postParentAdapter.refreshList(
                    list.meta as ArrayList<Meta>,
                    list.posts as ArrayList<ArrayList<Post>>
                )
            }
        }
    }


    private fun intiRecyclerView() {
        val viewManager = LinearLayoutManager(this)
        postParentAdapter =
            PostParentAdapter(ArrayList(), ArrayList(), this)
        binding.rvTransaction.apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = postParentAdapter
        }
    }

}