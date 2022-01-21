package dev.eighteentech.brook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import dagger.hilt.EntryPoint
import dev.eighteentech.brook.ui.theme.BrookTheme
import dev.eighteentech.brook.ui.views.MainView

@EntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var account: GoogleSignInAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrookTheme {
                MainView()
            }
        }
    }
}
