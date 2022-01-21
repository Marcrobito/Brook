package dev.eighteentech.brook.entities

import java.text.SimpleDateFormat
import java.util.*

data class PressureMeasure(
    val systolic: Double,
    val diastolic: Double,
    val timestamp: Long,
) {
    private val date = Date(timestamp)
    private val datePattern = "dd/MM/yyyy"
    private val timePattern = "HH:mm"

    fun getDate(): String = SimpleDateFormat(datePattern).format(date)
    fun getTime(): String  = SimpleDateFormat(timePattern).format(date)
    fun isHighPressure() = systolic >= 122 || diastolic >= 82
}
