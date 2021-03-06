package com.example.runingapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.runingapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {
    val totalTimeRun = mainRepository.getTotalTimeInMills()
    val totalDistance = mainRepository.getTotalDistanceInMeters()
    val totalCaloriesBurned = mainRepository.getTotalCaloriesBurned()
    val totalAvgSpeed = mainRepository.getTotalAvgSpeedInKMH()
    val runsSortedByDate = mainRepository.getRunsSortedByDate()
}