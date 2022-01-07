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

    private val ownerId = state.get<Long>("ownerId") ?: 0L

    val campuses: LiveData<List<Campus>> = repository.getCampusesByOwnerId(ownerId)

    fun onCampusClick() = viewModelScope.launch {
        campusEventChannel.send(CampusEvent.NavigateToMapFragment)
    }

    sealed class CampusEvent{
        object NavigateToMapFragment : CampusEvent()
    }

}