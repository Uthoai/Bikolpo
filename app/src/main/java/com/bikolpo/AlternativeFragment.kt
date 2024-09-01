package com.bikolpo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bikolpo.databinding.FragmentAlternativeBinding
import com.bumptech.glide.Glide

class AlternativeFragment : Fragment() {
    private lateinit var binding: FragmentAlternativeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlternativeBinding.inflate(inflater, container, false)

        val args = AlternativeFragmentArgs.fromBundle(requireArguments())
        val brandItem = args.brandItem

        binding.apply {
            Glide.with(requireContext())
                .load(brandItem.image)
                .into(ivItemImage)
            tvItemName.text = brandItem.name
        }

        return binding.root
    }
}