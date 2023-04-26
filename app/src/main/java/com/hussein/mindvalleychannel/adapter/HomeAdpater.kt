package com.hussein.mindvalleychannel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hussein.mindvalleychannel.databinding.CategoryItemLayoutBinding
import com.hussein.mindvalleychannel.databinding.ChannelItemLayoutBinding
import com.hussein.mindvalleychannel.databinding.EpisodeItemLayoutBinding
import com.hussein.mindvalleychannel.model.*
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.channel.Channel
import com.hussein.mindvalleychannel.model.episode.Episode

/** This Adapter for Handling Home Data like sections in Home **/
class HomeAdpater (context:Context, private val mList:List<MainResponse>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var bindingEpisode: EpisodeItemLayoutBinding
    private lateinit var bindingChannel: ChannelItemLayoutBinding
    private lateinit var bindingCategory: CategoryItemLayoutBinding
    val mContext=context

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // that is used to hold list item
        when (viewType) {
            MainResponse.VIEW_TYPE_EPISODE -> {
                bindingEpisode = EpisodeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return EpisodeViewHolder(bindingEpisode)
            }
            MainResponse.VIEW_TYPE_CHANNEL -> {
                bindingChannel = ChannelItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ChannelViewHolder(bindingChannel)
            }
            else -> {
                bindingCategory = CategoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CategoryViewHolder(bindingCategory)
            }
        }
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mList[position]
        if(getItemViewType(position)==MainResponse.VIEW_TYPE_EPISODE){
            (holder as EpisodeViewHolder).bind(item.model as Episode,mContext)
        }
        else if(getItemViewType(position)==MainResponse.VIEW_TYPE_CHANNEL){
            (holder as ChannelViewHolder).bind(item.model as Channel,mContext)
        }
        else {
            (holder as CategoryViewHolder).bind(item.model as Category,mContext)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return mList[position].viewType
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class EpisodeViewHolder(private val binding: EpisodeItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: Episode,context: Context) {
            try {
                if (episode.data.media.isNotEmpty()) {
                    binding.lyEpisode.visibility = View.VISIBLE
                    binding.rvEpisode.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    binding.rvEpisode.adapter = EpisodeAdapter(context, episode.data.media)
                } else {
                    binding.lyEpisode.visibility = View.GONE
                }
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
    class ChannelViewHolder(private val binding: ChannelItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(channel: Channel,context: Context) {
            try {
                if (channel.data.channels.isNotEmpty()) {
                    binding.rvChannel.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.rvChannel.adapter = ChannelAdapter(context, channel.data.channels)
                } else {
                    binding.lyChannel.visibility = View.GONE
                }
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
    class CategoryViewHolder(private val binding: CategoryItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category,context: Context) {
            try {
                if (category.data.categories.isNotEmpty()) {
                    binding.lyCategory.visibility = View.VISIBLE
                    binding.rvCategory.layoutManager = GridLayoutManager(context, 2)
                    binding.rvCategory.adapter = CategoryAdapter(context, category.data.categories)
                } else {
                    binding.lyCategory.visibility = View.GONE
                }
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}