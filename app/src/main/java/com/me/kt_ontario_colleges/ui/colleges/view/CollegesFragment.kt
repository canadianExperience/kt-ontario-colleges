package com.me.kt_ontario_colleges.ui.colleges.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.databinding.FragmentCollegesBinding
import com.me.kt_ontario_colleges.ui.colleges.viewmodel.CollegesViewModel
import javax.inject.Inject

class CollegesFragment @Inject constructor(
    private val collegesRecyclerViewAdapter: CollegesRecyclerViewAdapter
) : Fragment(R.layout.fragment_colleges) {
    private var fragmentBinding: FragmentCollegesBinding? = null
    private lateinit var viewModel: CollegesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCollegesBinding.bind(view)
        fragmentBinding = binding

        viewModel = ViewModelProvider(requireActivity())[CollegesViewModel::class.java]

        binding.collegesRecyclerView.apply {
            adapter = collegesRecyclerViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.colleges.observe(viewLifecycleOwner){
            collegesRecyclerViewAdapter.colleges = it
        }
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }
}