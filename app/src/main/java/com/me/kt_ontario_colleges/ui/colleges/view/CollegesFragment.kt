package com.me.kt_ontario_colleges.ui.colleges.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.databinding.FragmentCollegesBinding
import com.me.kt_ontario_colleges.ui.colleges.viewmodel.CollegesViewModel
import com.me.kt_ontario_colleges.ui.exhaustive
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CollegesFragment : Fragment(R.layout.fragment_colleges) {
    private var fragmentBinding: FragmentCollegesBinding? = null

    private val viewModel: CollegesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCollegesBinding.bind(view)
        fragmentBinding = binding

        val collegesRecyclerViewAdapter = CollegesRecyclerViewAdapter(viewModel.glide)

        binding.collegesRecyclerView.apply {
            adapter = collegesRecyclerViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }

        //Set college click
        collegesRecyclerViewAdapter.setOnItemClickListener {
            viewModel.onCollegeClick(it.first, it.second, it.third)
        }

        //Observe colleges
        viewModel.colleges.observe(viewLifecycleOwner){
            collegesRecyclerViewAdapter.colleges = it
        }

        //College events
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.collegeEvent.collect { event->
                when(event){
                    is CollegesViewModel.CollegeEvent.NavigateToCampusesFragment -> {
                        goToCampusesFragment(event.collegeId, event.logo, event.name)
                    }
                }.exhaustive

            }
        }
    }

    private fun goToCampusesFragment(collegeId: Long, logo: Int, name: String) {
        val action = CollegesFragmentDirections.actionCollegesToCampuses(collegeId, logo, name)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }
}