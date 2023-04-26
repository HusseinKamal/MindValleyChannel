package com.hussein.mindvalleychannel.adapter

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hussein.mindvalleychannel.databinding.ChannelRowItemLayoutBinding
import com.hussein.mindvalleychannel.model.channel.LatestMedia
import com.hussein.mindvalleychannel.utils.Constant
import com.hussein.mindvalleychannel.utils.ImageUtil

/** This Adapter for Handling Courses sections in Home **/
class CourseAdapter (context: Context, private val mList: List<LatestMedia>) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    private lateinit var binding: ChannelRowItemLayoutBinding
    val mContext= context
    val size:Int= Constant.getViewHolderITemSize(mContext as Activity)

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // that is used to hold list item
        binding = ChannelRowItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.bind(item,size)

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(private val binding: ChannelRowItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: LatestMedia, size:Int) {
            try {
                //Image Asset
                ImageUtil.bindUrlImage(binding.ivAsset, model.coverAsset.url, size, size, 8, 0)
                //Title
                if (!TextUtils.isEmpty(model.title)) {
                    binding.tvTitle.text = model.title
                    binding.tvTitle.visibility = View.VISIBLE
                } else {
                    binding.tvTitle.visibility = View.GONE
                }
                binding.lyChannel.layoutParams.width=size
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}