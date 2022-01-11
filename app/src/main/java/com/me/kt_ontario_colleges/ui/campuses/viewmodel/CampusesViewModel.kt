package com.me.kt_ontario_colleges.ui.campuses.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.me.kt_ontario_colleges.repository.CollegeRepositoryInterface
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.ui.colleges.viewmodel.CollegesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CampusesViewModel @Inject constructor(
    private val repository: CollegeRepositoryInterface,
    private val state: SavedStateHandle
): ViewModel(){
    private val campusEventChannel = Channel<CampusEvent>()
    val campusEvent = campusEventChannel.receiveAsFlow()

    private val collegeId = state.get<Long>("collegeId") ?: 0L
    private val logo = state.get<Int>("logo") ?: 0

    val campuses: LiveData<List<Campus>> = repository.getCampusesByOwnerId(collegeId)

    fun onCampusClick(campusId: Long, collegeId: Long) = viewModelScope.launch {
        campusEventChannel.send(CampusEvent.NavigateToMapFragment(campusId, collegeId, logo))
    }

    sealed class CampusEvent{
        data class NavigateToMapFragment(val campusId: Long, val collegeId: Long, val logo: Int) : CampusEvent()
    }

}