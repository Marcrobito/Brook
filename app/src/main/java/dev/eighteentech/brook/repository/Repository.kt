package dev.eighteentech.brook.repository

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.data.HealthDataTypes
import com.google.android.gms.fitness.request.DataReadRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.eighteentech.brook.base.FITNESS_OPTIONS
import dev.eighteentech.brook.base.toBloodPressureList
import dev.eighteentech.brook.entities.FitResult
import dev.eighteentech.brook.entities.PressureMeasure
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine


class Repository @Inject constructor(@ApplicationContext private val context: Context) {


    private fun getGoogleAccount() = GoogleSignIn.getAccountForExtension(context, FITNESS_OPTIONS)

    fun oAuthPermissionsApproved() =
        GoogleSignIn.hasPermissions(getGoogleAccount(), FITNESS_OPTIONS)


    suspend fun readHistoryData(): FitResult<List<PressureMeasure>> {
        val readRequest = queryFitnessData()

        return suspendCoroutine { continuation ->
            Fitness.getHistoryClient(context, getGoogleAccount())
                .readData(readRequest)
                .addOnSuccessListener { dataReadResponse ->
                    val measures = dataReadResponse.buckets.filter {
                        it.dataSets[0].dataPoints.isNotEmpty()
                    }.toBloodPressureList().toMutableList()
                    measures.sortByDescending { it.timestamp }
                    continuation.resumeWith(Result.success(FitResult.Success(measures)))
                }
                .addOnFailureListener { e ->
                    continuation.resumeWith(Result.success(FitResult.Fail(e)))
                }
        }
    }

    private fun queryFitnessData(): DataReadRequest {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        val now = Date()
        calendar.time = now
        val endTime = calendar.timeInMillis
        calendar.add(Calendar.MONTH, -1)
        val startTime = calendar.timeInMillis

        return DataReadRequest.Builder()
            .aggregate(HealthDataTypes.TYPE_BLOOD_PRESSURE)
            .bucketByTime(1, TimeUnit.DAYS) //important thing
            .setTimeRange(startTime, endTime, TimeUnit.MILLISECONDS)
            .enableServerQueries()
            .build()
    }


}