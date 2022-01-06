package com.me.kt_ontario_colleges.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "campuses_table")
data class Campus(
    var name: String,
    var address: String,
    var phone: String,
    var ownerId: Int,

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)
