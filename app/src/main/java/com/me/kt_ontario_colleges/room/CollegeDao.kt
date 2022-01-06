package com.me.kt_ontario_colleges.room
import androidx.lifecycle.LiveData
import androidx.room.*
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

@Dao
interface CollegeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCampus(campus: Campus)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCampuses(campuses: List<Campus>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollege(college: College): Long

    @Query("SELECT * FROM colleges_table")
    fun getColleges(): LiveData<List<College>>

    @Transaction
    suspend fun insertCompletedCollege(
        college: College,
        campuses: List<Campus>
    ){
        withContext(IO){
            val ownerId = async {insertCollege(college)}
            val id = ownerId.await()

            campuses.toMutableList().map { it.ownerId = id }
            insertCampuses(campuses)
        }
    }
}