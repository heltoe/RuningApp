package com.example.runingapp.utils

import android.content.Context
import android.icu.util.Calendar
import com.example.runingapp.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    val runs: List<Run>,
    c: Context,
    layoutId: Int
) : MarkerView(c, layoutId) {
    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())

    }
    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (e == null) {
            return
        }
        val curRunId = e.x.toInt()
        val run = runs[curRunId]
//        val calendar = Calendar.getInstance().apply {
//            timeInMillis = run.timestamp
//        }
//        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
//        holder.binding.tvDate.text = dateFormat.format(calendar.time)
//        val avgSpeed = "${run.avgSpeedInKMH}km/h"
//        holder.binding.tvAvgSpeed.text = avgSpeed
//        val distanseInKm = "${run.distanceInMeters / 1000f}km"
//        holder.binding.tvDistance.text = distanseInKm
//        holder.binding.tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
//        val caloriesBurned = "${run.caloriesBurned}kcal"
//        holder.binding.tvCalories.text = caloriesBurned
    }
}