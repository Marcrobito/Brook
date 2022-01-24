package dev.eighteentech.brook

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.result.DataReadResponse
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint
import dev.eighteentech.brook.base.FitBaseActivity
import dev.eighteentech.brook.ui.theme.BrookTheme
import dev.eighteentech.brook.ui.views.MainView

@AndroidEntryPoint
class MainActivity : FitBaseActivity() {


    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrookTheme {
                MainView(viewModel) {
                    fitSignIn()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            RESULT_OK -> {
                Log.d("SA","ASD $resultCode $requestCode")
                //val postSignInAction = FitActionRequestCode.values()[requestCode]
                //postSignInAction.let {
                // performActionForRequestCode(postSignInAction)
                //}
            }
            else-> displayToast(R.string.error_login_message)
        }
    }






}
