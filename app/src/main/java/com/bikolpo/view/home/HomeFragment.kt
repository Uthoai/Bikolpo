package com.bikolpo.view.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bikolpo.databinding.FragmentHomeBinding
import com.bikolpo.repository.Repository
import com.bikolpo.service.Network

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Create the repository and inject it into the ViewModel
        val repository = Repository(Network.apiService)
        viewModel = HomeViewModel(repository)

        // Observe LiveData and update UI
        viewModel.categories.observe(viewLifecycleOwner, Observer { response ->
            response?.let {
                /*if (it.isSuccessful) {
                    Log.d("TAG", "onCreateView: ${response}")
                } else {
                    // Handle error
                }*/
            }
        })

        return binding.root
    }
}