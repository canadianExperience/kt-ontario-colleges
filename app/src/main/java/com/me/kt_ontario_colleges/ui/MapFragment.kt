package com.me.kt_ontario_colleges.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.databinding.FragmentMapBinding

class MapFragment: Fragment(R.layout.fragment_map) {
    private var fragmentBinding: FragmentMapBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMapBinding.bind(view)
        fragmentBinding = binding
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }
}