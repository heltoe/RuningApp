package com.example.runingapp.repositories

import com.example.runingapp.db.Run
import com.example.runingapp.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getRunsSortedByDate() = runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistanceInMeters() = runDao.getAllRunsSortedByDistanceInMeters()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByAvgSpeedInKMH() = runDao.getAllRunsSortedByAvgSpeedInKMH()

    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()

    fun getTotalAvgSpeedInKMH() = runDao.getTotalAvgSpeedInKMH()

    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    fun getTotalDistanceInMeters() = runDao.getTotalDistanceInMeters()

    fun getTotalTimeInMills() = runDao.getTotalTimeInMills()
}