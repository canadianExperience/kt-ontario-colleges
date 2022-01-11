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
import com.google.android.gms.maps.model.MarkerOptions

import com.me.kt_ontario_colleges.databinding.FragmentMapBinding
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.ui.map.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.me.kt_ontario_colleges.ui.map.ClusterMarker


import com.google.maps.android.clustering.ClusterManager
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.ui.map.ClusterManagerRenderer
import com.google.android.gms.maps.model.LatLngBounds









@AndroidEntryPoint
class MapFragment: Fragment(R.layout.fragment_map)
//OnMapReadyCallback
{
    private var fragmentBinding: FragmentMapBinding? = null
    private val viewModel: MapViewModel by viewModels()

    private val TAG = "UserListFragment"


    private lateinit var geocoder: Geocoder
    private lateinit var clusterManager: ClusterManager<ClusterMarker>



    private lateinit var clusterManagerRenderer: ClusterManagerRenderer
    private val clusterMarkers = arrayListOf<ClusterMarker>()
    private lateinit var mapBoundary: LatLngBounds
    private var position: Address? = null

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

    private fun updateMap(campuses: List<Campus>) {
        campuses.map { campus ->

            val location = geocoder.getFromLocationName(campus.address, 1).first()
            val name = campus.name
            val latLng = LatLng(location.latitude, location.longitude)

            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(name)
            )
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng))

        }
    }


    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }


    private fun setUpClusterer(campuses: List<Campus>) {
        //Move camera to clicked campus location
        val campus = campuses.first { it.id == viewModel.campusId }
        val position = geocoder.getFromLocationName(campus.address, 1).first()

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(position.latitude, position.longitude), 10f))
        clusterManager = ClusterManager(context, map)

        // Point the map's listeners at the listeners implemented by the cluster
        // manager.
        map.setOnCameraIdleListener(clusterManager)
        map.setOnMarkerClickListener(clusterManager)
        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isMyLocationButtonEnabled = true

        // Add cluster items (markers) to the cluster manager.
        campuses.map {
            val location = geocoder.getFromLocationName(it.address, 1).first()
            val marker = ClusterMarker(location.latitude, location.longitude, it.name, it.phone)
            clusterManager.addItem(marker)
        }

        clusterManager.setAnimation(false)

    }

}