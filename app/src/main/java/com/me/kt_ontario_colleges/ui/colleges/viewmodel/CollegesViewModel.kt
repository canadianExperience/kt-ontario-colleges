package com.me.kt_ontario_colleges.ui.colleges.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.me.kt_ontario_colleges.repository.CollegeRepositoryInterface
import com.me.kt_ontario_colleges.room.entity.College
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollegesViewModel @Inject constructor(
    private val repository: CollegeRepositoryInterface
): ViewModel(){
    val colleges: LiveData<List<College>> = repository.getColleges()
}