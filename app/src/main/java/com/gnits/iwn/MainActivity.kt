package com.gnits.iwn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.gnits.iwn.Login.PostOfficeApp
import com.gnits.iwn.ui.theme.IwnTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    // See: https://developer.android.com/training/basics/intents/result
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract(),
    ) { res ->
        this.onSignInResult(res)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val user = FirebaseAuth.getInstance().currentUser
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }

    // Choose authentication providers
    val providers = arrayListOf(

        AuthUI.IdpConfig.PhoneBuilder().build()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUi(onLoginClick =
            {
                // Create and launch sign-in intent
                val signInIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build()
                signInLauncher.launch(signInIntent)
            },
                onLogoutClick = {
                    AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener {
                            // ...
                        }
                })
        }

    }
}
    @Composable
    fun LoginUi(onLoginClick: ()-> Unit,onLogoutClick: ()-> Unit)
    {
        val user=FirebaseAuth.getInstance().currentUser
        Column {
           if (user==null) {
               Button(onClick = { onLoginClick() }) {
                   Text(text = "NGO Login")
               }
           }else {
               Button(onClick = {onLogoutClick()}) {
                   Text(text = "Logout")
               }
           }

       }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IwnTheme {
        Greeting("Android")
    }
}