package com.bikolpo.view.alternative

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bikolpo.adapter.AlternativeBrandAdapter
import com.bikolpo.databinding.FragmentAlternativeBinding
import com.bikolpo.utils.stringToList
import com.bumptech.glide.Glide

class AlternativeFragment : Fragment() {
    private lateinit var binding: FragmentAlternativeBinding
    private val viewModel: AlternativeViewModel by viewModels()
    private lateinit var adapter: AlternativeBrandAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlternativeBinding.inflate(inflater, container, false)
        var alternativeList = listOf<Int>()
        val args = AlternativeFragmentArgs.fromBundle(requireArguments())
        val brandItem = args.brandItem

        binding.apply {
            Glide.with(requireContext())
                .load(brandItem.image)
                .into(ivItemImage)
            tvItemName.text = brandItem.name
        }

        if (brandItem.alternatives != null){
            brandItem.alternatives?.let {
                alternativeList = stringToList(it)
            }
        }

        viewModel.getAlternativesFromDatabase(alternativeList).observe(viewLifecycleOwner) { alternatives ->
            adapter = AlternativeBrandAdapter(alternatives)
            binding.recyclerViewBDBrands.adapter = adapter
        }

        return binding.root
    }
}