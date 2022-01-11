package com.me.kt_ontario_colleges.ui.map

import android.widget.ImageView
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator
import com.google.maps.android.clustering.Cluster

import com.google.android.gms.maps.model.BitmapDescriptorFactory

import android.graphics.Bitmap

import com.google.android.gms.maps.model.MarkerOptions


import android.content.Context

import com.google.maps.android.clustering.ClusterManager

import com.google.android.gms.maps.GoogleMap
import com.me.kt_ontario_colleges.R

class ClusterManagerRenderer(){

}

//open class ClusterManagerRenderer(
//    context: Context,
//    googleMap: GoogleMap,
//    clusterManager: ClusterManager<ClusterMarker>
//) : DefaultClusterRenderer<ClusterMarker>(context, googleMap, clusterManager) {
//
//    private val iconGenerator = IconGenerator(context.applicationContext)
//    private val imageView = ImageView(context.applicationContext)
//    private val markerWidth = context.resources.getDimension(R.dimen.custom_marker_image)
//    private val markerHeight = context.resources.getDimension(R.dimen.custom_marker_image)
//
//    init {
//
//        // initialize cluster item icon generator
//        val padding = context.resources.getDimension(R.dimen.custom_marker_padding).toInt()
//        imageView.apply {
//            layoutParams.height = markerHeight.toInt()
//            layoutParams.width = markerWidth.toInt()
//            setPadding(padding, padding, padding, padding)
//        }
//
//        iconGenerator.setContentView(imageView)
//    }
//
//
//    override fun onBeforeClusterItemRendered(item: ClusterMarker, markerOptions: MarkerOptions) {
//        imageView.setImageResource(item.iconPicture)
//        val icon = iconGenerator.makeIcon()
//        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(item.title)
//    }
//
//    override fun shouldRenderAsCluster(cluster: Cluster<ClusterMarker>): Boolean {
//        return false
//    }
//
//
//}