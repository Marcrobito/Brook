package dev.eighteentech.brook.entities

data class PressureMeasure(
    val systolic: Float,
    val diastolic: Float,
    val timestamp: Long,
) {
    fun isHighPressure() = systolic >= 122 || diastolic >= 82
}
