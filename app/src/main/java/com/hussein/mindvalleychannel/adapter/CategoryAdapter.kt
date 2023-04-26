package com.hussein.mindvalleychannel.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hussein.mindvalleychannel.databinding.CategoryRowLayoutBinding
import com.hussein.mindvalleychannel.model.category.CategoryName

/** This Adapter for Handling all sections Episodes,Courses,Series and Categories in Home **/
class CategoryAdapter (context: Context, private val mList: List<CategoryName>) : RecyclerView.Adapter<CategoryAdapter.CategoryItemViewHolder>() {
    private lateinit var binding: CategoryRowLayoutBinding
    val mContext=context

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        // that is used to hold list item
        binding = CategoryRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryItemViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        val item = mList[position]
        holder.bind(item)

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class CategoryItemViewHolder(private val binding: CategoryRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryName) {
            try {
                if (!TextUtils.isEmpty(category.name)) {
                    binding.tvCategoryName.text = category.name
                    binding.cardItem.visibility = View.VISIBLE
                } else {
                    binding.cardItem.visibility = View.GONE
                }
            }
            catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}