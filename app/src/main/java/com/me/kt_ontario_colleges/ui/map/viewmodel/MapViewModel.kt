package com.me.kt_ontario_colleges.ui.map.viewmodel

import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.clustering.ClusterItem
import com.me.kt_ontario_colleges.repository.CollegeRepositoryInterface
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.ui.colleges.viewmodel.CollegesViewModel
import com.me.kt_ontario_colleges.ui.map.util.ClusterMarker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repository: CollegeRepositoryInterface,
    private val geocoder: Geocoder,
    private val state: SavedStateHandle
): ViewModel(){
    private val mapEventChannel = Channel<MapEvent>()
    val mapEvent = mapEventChannel.receiveAsFlow()

    private val _isMapLoaded by lazy { MutableLiveData<Boolean>() }
    val isMapLoaded: LiveData<Boolean> get() = _isMapLoaded

    private val collegeId = state.get<Long>("collegeId") ?: 0L
    private val campusId = state.get<Long>("campusId") ?: 0L
    private val logo = state.get<Int>("logo") ?: 0

    val campuses: LiveData<List<Campus>> = repository.getCampusesByOwnerId(collegeId)

    init {
        _isMapLoaded.value = false
    }

    fun getLocations(campuses: List<Campus>) {
        val markers = mutableListOf<ClusterMarker>()
        var position: Address? = null
        var bounds: LatLngBounds? = null

        viewModelScope.launch {
            campuses.map {
                val location = getAddress(it.address)
                if(it.id == campusId) position = location
                val marker = ClusterMarker(location.latitude, location.longitude, "${it.name} Campus" , it.address, logo)
                markers.add(marker)
            }

            bounds = position?.let { getBounds(it) }

            mapEventChannel.send(MapEvent.MapReady(
                bounds,
                markers
            ))

            _isMapLoaded.postValue(true)
        }
    }

    private fun getAddress(str: String) = geocoder.getFromLocationName(str, 1).first()

    private fun getBounds(position: Address): LatLngBounds{
        val bottomBoundary = position.latitude - .1
        val leftBoundary = position.longitude - .1
        val topBoundary = position.latitude + .1
        val rightBoundary = position.longitude + .1

        return LatLngBounds(
            LatLng(bottomBoundary, leftBoundary),
            LatLng(topBoundary, rightBoundary)
        )
    }

    sealed class MapEvent{
        data class MapReady(
            val bounds: LatLngBounds?,
            val clusterMarkers: List<ClusterMarker>
        ) : MapEvent()
    }

}