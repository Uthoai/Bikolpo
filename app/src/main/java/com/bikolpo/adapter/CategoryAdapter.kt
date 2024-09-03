package com.bikolpo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bikolpo.R
import com.bikolpo.databinding.CategoryItemLayoutBinding
import com.bikolpo.model.CategoriesResponseItem

class CategoryAdapter(val list: List<CategoriesResponseItem>, val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var selectedItem = -1
    private var lastSelectedItem = -1

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

    override fun onBindViewHolder(holder: CategoryViewHolder, @SuppressLint("RecyclerView") position: Int) {
        list[position].let {item->
            holder.binding.textCategory.text = item.name

            holder.binding.root.setOnClickListener {
                lastSelectedItem = selectedItem
                selectedItem = position
                notifyItemChanged(lastSelectedItem)
                notifyItemChanged(selectedItem)

                onItemClick(item.id!!)
            }

            if (selectedItem == position) {
                holder.binding.root.setBackgroundResource(R.drawable.orange_bg)
            } else {
                holder.binding.root.setBackgroundResource(R.drawable.edittext_bg)
            }
        }
    }

    inner class CategoryViewHolder(var binding: CategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}