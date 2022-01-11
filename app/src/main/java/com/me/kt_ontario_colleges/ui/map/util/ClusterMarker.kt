package com.me.kt_ontario_colleges.ui.map.util

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class ClusterMarker(
    lat: Double,
    lng: Double,
    title: String,
    snippet: String,
    iconPicture: Int
) : ClusterItem {

    private val position: LatLng
    private val title: String
    private val snippet: String
    val iconPicture: Int


    override fun getPosition(): LatLng {
        return position
    }

    override fun getTitle(): String? {
        return title
    }

    override fun getSnippet(): String? {
        return snippet
    }

    init {
        position = LatLng(lat, lng)
        this.title = title
        this.snippet = snippet
        this.iconPicture = iconPicture
    }
}