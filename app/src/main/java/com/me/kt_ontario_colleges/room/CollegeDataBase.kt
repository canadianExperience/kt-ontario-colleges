package com.me.kt_ontario_colleges.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College

@Database(entities = [
    College::class,
    Campus::class
], version = 1)
abstract class CollegeDataBase: RoomDatabase() {
    abstract fun collegeDao(): CollegeDao
}