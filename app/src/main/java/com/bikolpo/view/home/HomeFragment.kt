package com.bikolpo.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bikolpo.adapter.CategoryAdapter
import com.bikolpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var adapter: CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        observer()

        return binding.root
    }

    private fun observer() {
        viewModel.categories.observe(viewLifecycleOwner){
            adapter = CategoryAdapter(it)
            binding.recyclerViewCategory.adapter = adapter
        }
    }
}