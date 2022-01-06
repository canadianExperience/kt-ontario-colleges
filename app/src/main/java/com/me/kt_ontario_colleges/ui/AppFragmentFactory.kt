package com.me.kt_ontario_colleges.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.me.kt_ontario_colleges.ui.colleges.view.CollegesFragment
import com.me.kt_ontario_colleges.ui.colleges.view.CollegesRecyclerViewAdapter
import javax.inject.Inject

class AppFragmentFactory @Inject constructor(
    private val collegesRecyclerViewAdapter: CollegesRecyclerViewAdapter
): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            CollegesFragment::class.java.name -> CollegesFragment(collegesRecyclerViewAdapter)

            else ->  super.instantiate(classLoader, className)
        }


    }
}