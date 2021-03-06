package ru.bedsus.spotifyapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import ru.bedsus.core.token.TokenManager
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.search.view.SearchFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val tokenManager: TokenManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (tokenManager.isToken().not()) {
            authorization()
        }
    }

    private fun authorization() {
        vLoading.show()
        val builder = AuthenticationRequest.Builder(
                CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI
        )
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
                    openSearch()
                }
                AuthenticationResponse.Type.ERROR -> {
                    Timber.d(response.error)
                }
                else -> {
                    Timber.d(response.error)
                }
            }
            vLoading.hide()
        }
    }

    private fun openSearch() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.vContainerFrag, SearchFragment())
                .commit()
    }

    private fun saveToken(response: AuthenticationResponse) {
        tokenManager.setTokens(response.accessToken)
        Timber.d(response.accessToken)
    }

    companion object {
        const val REQUEST_CODE = 1337
        const val REDIRECT_URI = "bedsus://spotifyapp"
        const val CLIENT_ID = "ae73e5bd5b6b4f04bbda7f9afaba4080"
    }

}