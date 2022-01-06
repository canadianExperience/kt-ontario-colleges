package com.me.kt_ontario_colleges.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colleges_table")
data class College(
    var name: String,

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
)
