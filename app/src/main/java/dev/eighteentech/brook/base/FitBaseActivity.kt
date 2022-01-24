package dev.eighteentech.brook.base

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.*
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.FitnessOptions
import com.google.android.gms.fitness.data.DataType
import com.google.android.gms.fitness.data.HealthDataTypes
import com.google.android.gms.fitness.data.HealthFields.*
import com.google.android.gms.fitness.request.DataReadRequest
import com.google.android.gms.fitness.result.DataReadResponse
import com.google.android.gms.tasks.Task
import dev.eighteentech.brook.R
import dev.eighteentech.brook.R.string.error_login_message
import dev.eighteentech.brook.entities.PressureMeasure
import java.util.*
import java.util.concurrent.TimeUnit


private const val INSERT_AND_READ_DATA = 0

open class FitBaseActivity : ComponentActivity() {


    var isAuthPermissionGranted = false

    private fun getGoogleAccount() = GoogleSignIn.getAccountForExtension(this, FITNESS_OPTIONS)

    fun fitSignIn() {
        if (!isAuthPermissionGranted) {
            getGoogleAccount()
        }
    }

    fun displayToast(stringId: Int) {
        Toast.makeText(this, getString(stringId), Toast.LENGTH_LONG).show()
    }



}