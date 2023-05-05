package com.hussein.mindvalleychannel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.hussein.mindvalleychannel.adapter.HomeAdpater
import com.hussein.mindvalleychannel.databinding.ActivityMainBinding
import com.hussein.mindvalleychannel.viewmodel.home.HomeViewModel
import com.hussein.mindvalleychannel.viewmodel.home.HomeViewModelFactory
import javax.inject.Inject

/** This Activity for showing Home data and views like Episodes,Channels(Series,Courses) and Categories etc **/
class MainActivity : AppCompatActivity(),SwipeRefreshLayout.OnRefreshListener {
    lateinit var binding: ActivityMainBinding
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as App).component.inject(this)
        homeViewModel= ViewModelProvider(this,homeViewModelFactory)[HomeViewModel::class.java]
        initView()

    }
    private fun initView()
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvChannels.layoutManager = layoutManager
        binding.rvChannels.setHasFixedSize(true)
        binding.rvChannels.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        binding.swipe.setOnRefreshListener(this)
        getHomeDB()
    }
    private fun getHomeDB()
    {
        try {
            //Get Products from DB if DB not empty else get from API
            binding.progress.visibility = View.VISIBLE
            homeViewModel.getHomeDB().observe(this) { home ->
                if (home.isNotEmpty()) {
                    if(home[0]!=null) {
                        binding.rvChannels.adapter = HomeAdpater(this, home)
                        showView()
                    }
                    else {
                        callHomeAPI()
                    }
                } else {
                    callHomeAPI()
                }
            }
        }
        catch (ex:Exception){
            ex.printStackTrace()
        }
    }
    private fun callHomeAPI()
    {
        try {
            binding.progress.visibility = View.VISIBLE
            homeViewModel.getHome().observe(this) { home ->
                if (home.isNotEmpty()) {
                    //applicationContext is better to use to avoid memory leak ad this maybe end but applicationContext is still alive and retain its reference
                    binding.rvChannels.adapter = HomeAdpater(applicationContext, home)
                    showView()
                } else {
                    hideView()
                }
            }
        }
        catch (ex:Exception){
            ex.printStackTrace()
        }
    }

    private fun showView(){
        try {
            binding.rvChannels.visibility = View.VISIBLE
            binding.tvNoData.visibility = View.GONE
            binding.progress.visibility = View.GONE
            binding.swipe.isRefreshing = false
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
    private fun hideView(){
        try {
            binding.rvChannels.visibility = View.GONE
            binding.tvNoData.visibility = View.VISIBLE
            binding.progress.visibility = View.GONE
            binding.swipe.isRefreshing = false
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
    override fun onRefresh() {
        try {
            callHomeAPI()
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
}