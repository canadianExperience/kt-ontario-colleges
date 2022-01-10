package com.me.kt_ontario_colleges.ui.map.view

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
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.databinding.FragmentMapBinding
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.ui.map.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment: Fragment(R.layout.fragment_map)
//OnMapReadyCallback
{
    private var fragmentBinding: FragmentMapBinding? = null
    private val viewModel: MapViewModel by viewModels()

    private lateinit var map: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMapBinding.bind(view)
        fragmentBinding = binding
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        //Observe campuses
        viewModel.campuses.observe(viewLifecycleOwner){campuses->

            campuses?.let {

                mapFragment.getMapAsync {googleMap ->
                    map = googleMap
                    updateMap(campuses)
                }

            }
        }
    }

    private fun updateMap(campuses: List<Campus>) {
        val geocoder = Geocoder(requireContext())

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

//    override fun onMapReady(googleMap: GoogleMap) {
//        // Add a marker in Sydney and move the camera
//        map = googleMap
//        val sydney = LatLng(-34.0, 151.0)
//        map.addMarker(MarkerOptions()
//            .position(sydney)
//            .title("Marker in Sydney"))
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//
//       // updateMap()
//    }


}