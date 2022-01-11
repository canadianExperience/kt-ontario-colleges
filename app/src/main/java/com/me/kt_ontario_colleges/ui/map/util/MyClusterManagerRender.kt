package com.me.kt_ontario_colleges.ui.map.util

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator
import com.me.kt_ontario_colleges.R


class MyClusterManagerRenderer(
    context: Context,
    googleMap: GoogleMap,
    clusterManager: ClusterManager<ClusterMarker>
) : DefaultClusterRenderer<ClusterMarker>(context, googleMap, clusterManager) {

    private var iconGenerator = IconGenerator(context)
    private val imageView: ImageView = ImageView(context)

    init {
        val padding = context.resources.getDimension(R.dimen.custom_marker_padding).toInt()
        val markerWidth = context.resources.getDimension(R.dimen.custom_marker_image)
        val markerHeight = context.resources.getDimension(R.dimen.custom_marker_image)
        imageView.layoutParams = ViewGroup.LayoutParams(markerWidth.toInt(), markerHeight.toInt())
        imageView.setPadding(padding, padding, padding, padding)
        iconGenerator.setContentView(imageView)
    }


    override fun onBeforeClusterItemRendered(item: ClusterMarker, markerOptions: MarkerOptions) {
        imageView.setImageResource(item.iconPicture)
        val icon = iconGenerator.makeIcon()
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(item.title)
    }

    override fun onBeforeClusterRendered(
        cluster: Cluster<ClusterMarker>,
        markerOptions: MarkerOptions
    ) {
        super.onBeforeClusterRendered(cluster, markerOptions)
    }

    override fun onClusterItemRendered(clusterItem: ClusterMarker, marker: Marker) {
        super.onClusterItemRendered(clusterItem, marker)
        marker.title = clusterItem.title
        marker.snippet = clusterItem.snippet

//        if(clusterItem.showTitleWindow == clusterItem.title)
//        getMarker(clusterItem).showInfoWindow()
    }
}