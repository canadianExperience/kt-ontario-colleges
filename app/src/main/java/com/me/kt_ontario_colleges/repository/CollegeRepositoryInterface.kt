package com.me.kt_ontario_colleges.repository

import androidx.lifecycle.LiveData
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College

interface CollegeRepositoryInterface {
    suspend fun insertCompletedCollege(college: College, campuses: List<Campus>)
    fun getColleges(): LiveData<List<College>>
    fun getCampusesByOwnerId(id: Long): LiveData<List<Campus>>
}