package com.me.kt_ontario_colleges.ui.campuses.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.databinding.FragmentCampusesBinding
import com.me.kt_ontario_colleges.ui.campuses.viewmodel.CampusesViewModel
import com.me.kt_ontario_colleges.ui.colleges.view.CollegesFragmentDirections
import com.me.kt_ontario_colleges.ui.colleges.viewmodel.CollegesViewModel
import com.me.kt_ontario_colleges.ui.exhaustive
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CampusesFragment : Fragment(R.layout.fragment_campuses) {
    private var fragmentBinding: FragmentCampusesBinding? = null
    private val viewModel: CampusesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCampusesBinding.bind(view)
        fragmentBinding = binding

        val campusesRecyclerViewAdapter = CampusesRecyclerViewAdapter()
        binding.campusesRecyclerView.apply {
            adapter = campusesRecyclerViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }

        //Set college click
        campusesRecyclerViewAdapter.setOnItemClickListener {
            viewModel.onCampusClick()
        }

        //Observe colleges
        viewModel.campuses.observe(viewLifecycleOwner){
            campusesRecyclerViewAdapter.campuses = it
        }

        //Campus events
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.campusEvent.collect { event->
                when(event){
                    CampusesViewModel.CampusEvent.NavigateToMapFragment -> {
                        goToMapFragment()
                    }
                }.exhaustive
            }
        }
    }

    private fun goToMapFragment() {
        val action = CampusesFragmentDirections.actionCampusesToMap()
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

}