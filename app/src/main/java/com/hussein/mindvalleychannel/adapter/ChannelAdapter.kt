package com.hussein.mindvalleychannel.adapter
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hussein.mindvalleychannel.R
import com.hussein.mindvalleychannel.databinding.ChannelRowLayoutBinding
import com.hussein.mindvalleychannel.model.channel.ChannelItem
import com.hussein.mindvalleychannel.utils.ImageUtil
import com.hussein.mindvalleychannel.viewmodel.home.HomeViewModel

/** This Adapter for Handling Channels sections like Series and Courses in Home **/
class ChannelAdapter(context: Context, private val mList: List<ChannelItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var bindingSeries: ChannelRowLayoutBinding
    private lateinit var courseSeries: ChannelRowLayoutBinding
    val mContext=context

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // that is used to hold list item
        when (viewType) {
           1 -> { //1 for series
               bindingSeries = ChannelRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
               return SeriesViewHolder(bindingSeries)
            }
           2 -> { // 2 for course
               courseSeries = ChannelRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
               return CourseViewHolder(courseSeries)
            }
        }
        courseSeries = ChannelRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(courseSeries)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mList[position]
        if(getItemViewType(position)==1){
            (holder as SeriesViewHolder).bind(item,mContext)
        }
        else {
            (holder as CourseViewHolder).bind(item,mContext)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(mList[position].series.isNotEmpty())
            1
        else
            2
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class SeriesViewHolder(private val binding: ChannelRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ChannelItem, context: Context) {
            try {
                if (model != null) {
                    if (model.series.isNotEmpty()) {
                        binding.lyChannel.visibility = View.VISIBLE
                        //Image Asset
                        ImageUtil.bindUrlImage(binding.ivIcon, model.valueIconAsset.url)

                        //Title
                        if (!TextUtils.isEmpty(model.title)) {
                            binding.tvTitle.text = model.title
                            binding.tvTitle.visibility = View.VISIBLE
                        } else {
                            binding.tvTitle.visibility = View.GONE
                        }

                        //Series Count
                        binding.tvChannelNumber.text = model.series.size.toString()
                        binding.tvChannelNumber.append(context.resources.getString(R.string.series))

                        //Series RecyclerView
                        binding.rvChannel.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        binding.rvChannel.adapter = SeriesAdapter(context, model.series)
                    } else {
                        binding.lyChannel.visibility = View.GONE
                    }
                } else {
                    binding.lyChannel.visibility = View.GONE
                }
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
    class CourseViewHolder(private val binding: ChannelRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ChannelItem, context: Context) {
            try {
                if (model != null) {
                    if (model.latestMedia.isNotEmpty()) {
                        binding.lyChannel.visibility = View.VISIBLE
                        //Image Asset
                        ImageUtil.bindUrlImage(binding.ivIcon, model.valueIconAsset.url)

                        //Title
                        if (!TextUtils.isEmpty(model.title)) {
                            binding.tvTitle.text = model.title
                            binding.tvTitle.visibility = View.VISIBLE
                        } else {
                            binding.tvTitle.visibility = View.GONE
                        }

                        //Course Count
                        binding.tvChannelNumber.text = model.latestMedia.size.toString()
                        binding.tvChannelNumber.append(context.resources.getString(R.string.episodes))

                        //Course RecyclerView
                        binding.rvChannel.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        binding.rvChannel.adapter = CourseAdapter(context, model.latestMedia)
                    } else {
                        binding.lyChannel.visibility = View.GONE
                    }
                } else {
                    binding.lyChannel.visibility = View.GONE
                }
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}