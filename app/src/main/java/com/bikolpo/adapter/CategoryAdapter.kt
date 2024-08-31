package com.bikolpo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bikolpo.databinding.CategoryItemLayoutBinding
import com.bikolpo.model.CategoriesResponseItem

class CategoryAdapter(val list: List<CategoriesResponseItem>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        list[position].let {
            holder.binding.textCategory.text = it.name
        }
    }

    inner class CategoryViewHolder(var binding: CategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}