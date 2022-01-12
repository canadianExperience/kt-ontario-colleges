package com.me.kt_ontario_colleges.ui.colleges.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.me.kt_ontario_colleges.repository.CollegeRepositoryInterface
import com.me.kt_ontario_colleges.room.entity.College
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollegesViewModel @Inject constructor(
    private val repository: CollegeRepositoryInterface,
    val glide: RequestManager
): ViewModel(){
    private val collegeEventChannel = Channel<CollegeEvent>()
    val collegeEvent = collegeEventChannel.receiveAsFlow()


    val colleges: LiveData<List<College>> = repository.getColleges()

    fun onCollegeClick(id: Long, logo: Int, name: String) = viewModelScope.launch {
        collegeEventChannel.send(CollegeEvent.NavigateToCampusesFragment(id, logo, name))
    }

    sealed class CollegeEvent{
        data class NavigateToCampusesFragment(val collegeId: Long, val logo: Int, val name: String) : CollegeEvent()
    }

}