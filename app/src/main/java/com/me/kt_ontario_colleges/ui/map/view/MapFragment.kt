package com.me.kt_ontario_colleges.ui.map.view

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

import com.me.kt_ontario_colleges.databinding.FragmentMapBinding
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.ui.map.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.me.kt_ontario_colleges.ui.map.util.ClusterMarker


import com.google.maps.android.clustering.ClusterManager
import com.me.kt_ontario_colleges.R
import com.google.android.gms.maps.model.LatLngBounds
import com.me.kt_ontario_colleges.ui.map.util.MyClusterManagerRenderer


@AndroidEntryPoint
class MapFragment: Fragment(R.layout.fragment_map){
    private var fragmentBinding: FragmentMapBinding? = null
    private val viewModel: MapViewModel by viewModels()

    private lateinit var geocoder: Geocoder
    private lateinit var clusterManager: ClusterManager<ClusterMarker>
    private lateinit var clusterManagerRenderer: MyClusterManagerRenderer
    private lateinit var map: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        geocoder = Geocoder(requireContext())

        val binding = FragmentMapBinding.bind(view)
        fragmentBinding = binding
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        //Observe campuses
        viewModel.campuses.observe(viewLifecycleOwner){campuses->

            campuses?.let {
                mapFragment.getMapAsync {googleMap ->
                    map = googleMap
                    setUpClusterer(campuses)
                }
            }
        }
    }

    private fun setUpClusterer(campuses: List<Campus>) {
        val logo = viewModel.logo
        val campus = campuses.first { it.id == viewModel.campusId }
        val position = geocoder.getFromLocationName(campus.address, 1).first()

        clusterManager = ClusterManager(context, map)
        clusterManagerRenderer = MyClusterManagerRenderer(requireContext(), map, clusterManager)
        clusterManager.renderer = clusterManagerRenderer

        map.apply {
            setOnCameraIdleListener(clusterManager)
            setOnMarkerClickListener(clusterManager)
            uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }

        // Add cluster items (markers) to the cluster manager
        campuses.map {
            val location = geocoder.getFromLocationName(it.address, 1).first()
            val marker = ClusterMarker(location.latitude, location.longitude, "${it.name} Campus" , it.address, logo)
            clusterManager.addItem(marker)
        }
        clusterManager.cluster()

        setCameraView(position)

    }

    private fun setCameraView(position: Address) {
        val bottomBoundary = position.latitude - .1
        val leftBoundary = position.longitude - .1
        val topBoundary = position.latitude + .1
        val rightBoundary = position.longitude + .1
        val mapBoundary = LatLngBounds(
            LatLng(bottomBoundary, leftBoundary),
            LatLng(topBoundary, rightBoundary)
        )
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(mapBoundary, 0))
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }


}