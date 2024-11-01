package com.bikolpo.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bikolpo.adapter.BrandsAdapter
import com.bikolpo.adapter.CategoryAdapter
import com.bikolpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var brandsAdapter: BrandsAdapter
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
            categoryAdapter = CategoryAdapter(it){id->
                viewModel.filterBrandsByCategory(id)
            }
            binding.recyclerViewCategory.adapter = categoryAdapter
        }

        viewModel.indianBrands.observe(viewLifecycleOwner){
            brandsAdapter = BrandsAdapter(it){ selectedItem ->
                if (selectedItem.alternatives != null){
                    val action = HomeFragmentDirections.actionHomeFragmentToAlternativeFragment(selectedItem)
                    findNavController().navigate(action)
                }else{
                    Toast.makeText(requireContext(), "In Database there are no alternatives for this brand", Toast.LENGTH_SHORT).show()
                }
            }
            binding.recyclerViewBrands.adapter = brandsAdapter
        }

    }
}