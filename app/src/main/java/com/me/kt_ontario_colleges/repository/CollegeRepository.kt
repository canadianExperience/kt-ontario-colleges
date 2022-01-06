package com.me.kt_ontario_colleges.repository

import androidx.lifecycle.LiveData
import com.me.kt_ontario_colleges.room.CollegeDao
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College
import javax.inject.Inject

class CollegeRepository @Inject constructor(
    private val collegeDao: CollegeDao
) : CollegeRepositoryInterface {
    override suspend fun insertCompletedCollege(college: College, campuses: List<Campus>) = collegeDao.insertCompletedCollege(college, campuses)

    override fun getColleges(): LiveData<List<College>> = collegeDao.getColleges()
    override fun getCampusesByOwnerId(id: Long): LiveData<List<Campus>> = collegeDao.getCampusesByOwnerId(id)
}