package com.me.kt_ontario_colleges.room
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College

@Dao
interface CollegeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCampus(campus: Campus)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollege(college: College)

    @Query("SELECT * FROM colleges_table")
    fun getColleges(): LiveData<List<College>>
}