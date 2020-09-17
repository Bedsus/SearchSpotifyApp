package ru.bedsus.spotifyapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import org.koin.android.ext.android.inject
import ru.bedsus.core.token.TokenManager
import ru.bedsus.spotifyapp.R
import timber.log.Timber


class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val tokenManager: TokenManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authorization()
    }

    private fun authorization() {
        val builder = AuthenticationRequest.Builder(
            CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI
        )
       // builder.setScopes(arrayOf("streaming"))
        val request = builder.build()
        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            Timber.d(response.code)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    saveToken(response)
                    openMainActivity()
                }
                AuthenticationResponse.Type.ERROR -> {
                    Timber.d(response.error)
                }
                else -> {
                    Timber.d(response.error)
                }
            }
        }
    }

    private fun saveToken(response: AuthenticationResponse) {
        tokenManager.setTokens(response.accessToken)
        Timber.d(response.accessToken)
    }

    private fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    companion object {
        const val REQUEST_CODE = 1337
        const val REDIRECT_URI = "bedsus://spotifyapp"
        const val CLIENT_ID = "ae73e5bd5b6b4f04bbda7f9afaba4080"
    }
}