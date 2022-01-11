package com.me.kt_ontario_colleges.room

import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College

fun centennialCollege() = College("Centennial College", R.drawable.centennial)
fun senecaCollege() = College("Seneca", R.drawable.sececa)

fun centennialCollegeCampuses(): List<Campus>{
    val progress = Campus(
        "Progress",
        "941 Progress Avenue, Toronto, ON, M1G3T8",
        "",
        0L
    )
    val morningside = Campus(
        "Morningside",
        "755 Morningside Avenue, Toronto, ON, M1C5J9",
        "",
        0L
    )
    val pickering = Campus(
        "Pickering Learning Site",
        "1340 Pickering Parkway, Pickering, ON, L1V0C4",
        "",
        0L
    )
    val ashtonbee = Campus(
        "Ashtonbee",
        "75 Ashtonbee Road, Toronto, ON, M1L4C9",
        "",
        0L
    )
    val storyArtsCentre = Campus(
        "Story Arts Centre",
        "951 Carlaw Avenue, Toronto, ON, M4K3M2",
        "",
        0L
    )
    val downsview = Campus(
        "Downsview",
        "65 Carl Hall Road, Toronto, ON, M3K2E1",
        "",
        0L
    )
    val eglinton = Campus(
        "Eglinton Learning Site",
        "124 Eglinton Avenue West, Toronto, ON, M4R2G8",
        "",
        0L
    )

    return listOf(progress, morningside, pickering, ashtonbee, storyArtsCentre, downsview, eglinton)
}

fun senecaCollegeCampuses(): List<Campus> {
    val newnham = Campus(
        "Newnham",
        "1750 Finch Avenue East, Toronto, ON, M2J2X5",
        "0",
        0L
    )
    val jane = Campus(
        "Jane",
        "21 Beverly Hills Drive, Toronto, ON, M3L1A2",
        "",
        0L
    )
    val markham = Campus(
        "Markham",
        "8 The Seneca Way, Markham, ON, L3R5Y1",
        "",
        0L
    )
    val york = Campus(
        "Seneca York",
        "70 The Pond Road, Toronto, ON, M3J3M6",
        "",
        0L
    )
    val newmarket =  Campus(
        "Newmarket",
        "16655 Yonge Street, Newmarket, ON, L3X1V6",
        "",
        0L
    )
    val vaughan = Campus(
        "Vaughan",
        "1490 Major Mackenzie Drive West, Vaughan, ON, L6A4H6",
        "",
        0L
    )
    val king = Campus(
        "King",
        "13990 Dufferin Street, King City, ON, L7B1B3",
        "",
        0L
    )
    val peterborough = Campus(
        "Peterborough Aviation",
        "925 Airport Road, Peterborough, ON, K9J0E7",
        "",
        0L
    )
    val yorkgate = Campus(
        "Yorkgate",
        "1 York Gate Boulevard, North York, ON, M3N3A1",
        "",
        0L
    )

    return listOf(newnham, jane, markham, york, newmarket, vaughan, king, peterborough, yorkgate)
}