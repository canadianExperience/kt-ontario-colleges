package com.me.kt_ontario_colleges.room

import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College

fun centennialCollegeCampuses(): List<Campus>{
    val progress = Campus("Progress", "941 Progress Avenue, Toronto, ON, M1G3T8", "", 0L)
    val morningside = Campus("Morningside", "755 Morningside Avenue, Toronto, ON, M1C5J9", "", 0L)
    val pickering = Campus("Pickering Learning Site", "1340 Pickering Parkway, Pickering, ON, L1V0C4", "", 0L)
    val ashtonbee = Campus("Ashtonbee", "75 Ashtonbee Road, Toronto, ON, M1L4C9", "", 0L)
    val storyArtsCentre = Campus("Story Arts Centre", "951 Carlaw Avenue, Toronto, ON, M4K3M2", "", 0L)
    val downsview = Campus("Downsview", "65 Carl Hall Road, Toronto, ON, M3K2E1", "", 0L)
    val eglinton = Campus("Eglinton Learning Site", "124 Eglinton Avenue West, Toronto, ON, M4R2G8", "", 0L)

    return listOf(progress, morningside, pickering, ashtonbee, storyArtsCentre, downsview, eglinton)
}

fun centennialCollege() = College("Centennial College")