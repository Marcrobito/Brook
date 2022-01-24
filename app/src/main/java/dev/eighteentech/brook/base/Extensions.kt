package dev.eighteentech.brook.base

import com.google.android.gms.fitness.data.Bucket
import com.google.android.gms.fitness.data.HealthFields
import dev.eighteentech.brook.entities.PressureMeasure
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

private const val datePattern = "dd/MM/yyyy"
private const val timePattern = "HH:mm"
fun Long.getDate(): String = SimpleDateFormat(datePattern).format(this)
fun Long.getTime(): String = SimpleDateFormat(timePattern).format(this)

fun List<Bucket>.toBloodPressureList(): List<PressureMeasure> {
    val measures = mutableListOf<PressureMeasure>()
    try {
        this.forEach {
            it.dataSets[0].dataPoints.forEach { dataPoint ->
                measures.add(
                    PressureMeasure(
                        dataPoint.getValue(
                            HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE
                        ).asFloat(),
                        dataPoint.getValue(HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE)
                            .asFloat(),
                        it.getStartTime(TimeUnit.MILLISECONDS)
                    )
                )
            }
        }
    } catch (e: Exception) {

    }

    return measures
}