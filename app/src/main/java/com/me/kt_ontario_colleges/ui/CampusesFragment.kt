package com.me.kt_ontario_colleges.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.databinding.FragmentCampusesBinding

class CampusesFragment: Fragment(R.layout.fragment_campuses) {
    private var fragmentBinding: FragmentCampusesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCampusesBinding.bind(view)
        fragmentBinding = binding
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }
}