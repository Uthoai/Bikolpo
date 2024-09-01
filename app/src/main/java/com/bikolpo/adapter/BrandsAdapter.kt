package com.bikolpo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bikolpo.databinding.BrandsItemLayoutBinding
import com.bikolpo.model.IndianBrandsResponseItem
import com.bumptech.glide.Glide

class BrandsAdapter(
    val list: List<IndianBrandsResponseItem>,
    private val itemClickListener: (IndianBrandsResponseItem) -> Unit
) : RecyclerView.Adapter<BrandsAdapter.BrandsViewHolder>() {
    val alternatives: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandsViewHolder {
        return BrandsViewHolder(
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

    override fun onBindViewHolder(holder: BrandsViewHolder, position: Int) {
        list[position].let {item->
            holder.binding.apply {
                tvBrandName.text = item.name

                val alternatives = item.alternatives

                root.setOnClickListener {
                    if (alternatives != null) {
                        itemClickListener(item)
                    }
                }
            }
            Glide.with(holder.itemView.context)
                .load(item.image)
                .into(holder.binding.ivBrandImage)
        }
    }

    inner class BrandsViewHolder(val binding: BrandsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}