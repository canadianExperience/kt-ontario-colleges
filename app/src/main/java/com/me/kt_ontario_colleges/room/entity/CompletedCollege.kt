package com.me.kt_ontario_colleges.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "colleges_table")
data class CompletedCollege(
    @Embedded
    val college: College,

    @Relation(
        parentColumn = "id",
        entityColumn = "ownerId",
        entity = Campus::class
    )

    val campuses: List<Campus>
)
