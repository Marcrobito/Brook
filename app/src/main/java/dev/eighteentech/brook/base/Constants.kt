package dev.eighteentech.brook.base

import com.google.android.gms.fitness.FitnessOptions
import com.google.android.gms.fitness.data.HealthDataTypes

val FITNESS_OPTIONS: FitnessOptions by lazy {
    FitnessOptions.builder()
        .addDataType(HealthDataTypes.TYPE_BLOOD_PRESSURE, FitnessOptions.ACCESS_READ)
        .addDataType(HealthDataTypes.TYPE_BLOOD_PRESSURE, FitnessOptions.ACCESS_WRITE)
        .build()
}

const val SECOND_IN_MILLIS = 1000
const val MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60
const val HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60
const val DAY_IN_MILLIS = HOUR_IN_MILLIS * 24
const val MONTH_IN_MILLIS = DAY_IN_MILLIS * 30

