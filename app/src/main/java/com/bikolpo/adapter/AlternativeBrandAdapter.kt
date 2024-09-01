package com.bikolpo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bikolpo.databinding.BrandsItemLayoutBinding
import com.bikolpo.model.AlternativesResponseItem
import com.bumptech.glide.Glide

class AlternativeBrandAdapter(val list: List<AlternativesResponseItem>) :
    RecyclerView.Adapter<AlternativeBrandAdapter.AlternativeBrandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlternativeBrandViewHolder {
        return AlternativeBrandViewHolder(
            BrandsItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AlternativeBrandViewHolder, position: Int) {
        list[position].let {
            holder.apply {
                binding.tvBrandName.text = it.name
                Glide.with(itemView.context)
                    .load(it.image)
                    .into(binding.ivBrandImage)
            }
        }
    }

    inner class AlternativeBrandViewHolder(val binding: BrandsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}