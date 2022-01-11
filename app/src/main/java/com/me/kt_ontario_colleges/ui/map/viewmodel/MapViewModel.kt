package com.me.kt_ontario_colleges.ui.map.viewmodel

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
class MapViewModel @Inject constructor(
    private val repository: CollegeRepositoryInterface,
    private val state: SavedStateHandle
): ViewModel(){
    
    private val collegeId = state.get<Long>("collegeId") ?: 0L
    val campusId = state.get<Long>("campusId") ?: 0L
    val logo = state.get<Int>("logo") ?: 0

    val campuses: LiveData<List<Campus>> = repository.getCampusesByOwnerId(collegeId)


}