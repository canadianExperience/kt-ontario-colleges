package com.me.kt_ontario_colleges.room.util

import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College

fun centennialCollege() = College("Centennial", R.drawable.centennial)
fun senecaCollege() = College("Seneca", R.drawable.sececa)
fun canadoreCollege() = College("Canadore", R.drawable.canadore)
fun georgeBrownCollege() = College("George Brown", R.drawable.georgebrown)
fun humberCollege() = College("Humber", R.drawable.humber)
fun sheridanCollege() = College("Sheridan", R.drawable.sheridan)

fun centennialCampuses(): List<Campus>{
    val progress = Campus(
        "Progress",
        "941 Progress Avenue, Toronto, ON, M1G3T8",
        "Tel:416.289.5000",
        0L
    )
    val morningside = Campus(
        "Morningside",
        "755 Morningside Avenue, Toronto, ON, M1C5J9",
        "Tel:416.289.5000",
        0L
    )
    val ashtonbee = Campus(
        "Ashtonbee",
        "75 Ashtonbee Road, Toronto, ON, M1L4C9",
        "Tel:416.289.5000",
        0L
    )
    val storyArtsCentre = Campus(
        "Story Arts Centre",
        "951 Carlaw Avenue, Toronto, ON, M4K3M2",
        "Tel:416.289.5000",
        0L
    )
    val downsview = Campus(
        "Downsview",
        "65 Carl Hall Road, Toronto, ON, M3K2E1",
        "Tel:416.289.5000",
        0L
    )
    val eglinton = Campus(
        "Eglinton Learning Site",
        "124 Eglinton Avenue West, Toronto, ON, M4R2G8",
        "Tel:416.289.5000",
        0L
    )

    return listOf(progress, morningside, ashtonbee, storyArtsCentre, downsview, eglinton)
}
fun senecaCampuses(): List<Campus> {
    val newnham = Campus(
        "Newnham",
        "1750 Finch Avenue East, Toronto, ON, M2J2X5",
        "Tel:416.491.5050",
        0L
    )
    val york = Campus(
        "Seneca York",
        "70 The Pond Road, Toronto, ON, M3J3M6",
        "Tel:416.491.5050",
        0L
    )
    val king = Campus(
        "King",
        "13990 Dufferin Street, King City, ON, L7B1B3",
        "Tel:416.491.5050",
        0L
    )
    val yorkgate = Campus(
        "Yorkgate",
        "1 York Gate Boulevard, North York, ON, M3N3A1",
        "Tel:416.491.5050",
        0L
    )
    val peterborough = Campus(
        "Peterborough Aviation",
        "925 Airport Road, Peterborough, ON, K9J0E7",
        "Tel:416.491.5050",
        0L
    )
    val downtown = Campus(
        "Downtown",
        "18 King St. E., 17th floor, Toronto, ON, M3C1C4",
        "Tel:416.493.4144",
        0L
    )

    return listOf(newnham, york, king, peterborough, yorkgate, downtown)
}
fun canadoreCampuses(): List<Campus>{
    val collegeDrive = Campus(
        "College Drive",
        "100 College Drive, North Bay, ON, P1B8K9",
        "Tel:705.474.7600",
        0L
    )
    val commerceCourt = Campus(
        "Commerce Court",
        "60 Commerce Crescent, North Bay, ON, P1B8G4",
        "Tel:705.474.7600",
        0L
    )
    val aviationTechnology = Campus(
        "Aviation Technology",
        "55 Aviation Avenue, North Bay, ON, P1B8G2",
        "Tel:705.474.7600",
        0L
    )
    val westParrySound = Campus(
        "West Parry Sound",
        "1 College Drive, Parry Sound, ON, P2A0A9",
        "Tel:705.746.9222",
        0L
    )

    return listOf(collegeDrive, commerceCourt, aviationTechnology, westParrySound)
}
fun georgeBrownCampuses(): List<Campus>{
    val stJamesCampus = Campus(
        "St. James Campus",
        "200 King Street East, Toronto, ON, M5A3W8",
        "Tel:416.415.2000 x4805",
        0L
    )
    val ryersonUniversity = Campus(
        "Ryerson University",
        "99 Gerrard Street East, Toronto, ON, M5B2K8",
        "Tel:416.415.2000 x4805",
        0L
    )
    val waterfront = Campus(
        "Waterfront",
        "51 Dockside Drive, Toronto, ON, M5A0B6",
        "Tel:416.415.2000 x4805",
        0L
    )
    val casaLomaCampus = Campus(
        "Casa Loma Campus",
        "160 Kendal Avenue, Toronto, ON, M5R1M3",
        "Tel:416.415.2000 x4805",
        0L
    )
    val schoolOfPerformingArts = Campus(
        "School of Performing Arts",
        "50 Tankhouse Lane, Toronto, ON, M5A3C4",
        "Tel:416.415.2000 x4805",
        0L
    )
    return listOf(stJamesCampus, ryersonUniversity, waterfront, casaLomaCampus, schoolOfPerformingArts)
}
fun humberCampuses(): List<Campus>{
    val north = Campus(
        "North",
        "205 Humber College Boulevard, Toronto, ON, M9W5L7",
        "Tel:416.675.3111",
        0L
    )
    val orangeville = Campus(
        "Orangeville",
        "275 Alder Street, Orangeville, ON, L9W5A9",
        "Tel:1.877.675.3111",
        0L
    )
    val lakeshore = Campus(
        "Lakeshore",
        "3199 Lake Shore Boulevard West, Toronto, ON, M8V1K8",
        "Tel:416.675.3111",
        0L
    )
    return listOf(north, orangeville, lakeshore)
}
fun sheridanCampuses(): List<Campus>{
    val trafalgar = Campus(
        "Trafalgar",
        "1430 Trafalgar Road, Oakville, ON, L6H2L1",
        "Tel:905.845.9430",
        0L
    )
    val hazelMcCallion = Campus(
        "Hazel McCallion",
        "4180 Duke of York Boulevard, Mississauga, ON, L5B0G5",
        "Tel:905.845.9430",
        0L
    )
    val davis = Campus(
        "Davis",
        "7899 Mclaughlin Road, Brampton, ON, L6Y5H9",
        "Tel:905.459.7533",
        0L
    )
    return listOf(trafalgar, hazelMcCallion, davis)
}