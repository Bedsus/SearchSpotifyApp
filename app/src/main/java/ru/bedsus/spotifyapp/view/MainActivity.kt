package ru.bedsus.spotifyapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import org.koin.android.ext.android.inject
import ru.bedsus.core.token.TokenManager
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.databinding.ActivityMainBinding
import ru.bedsus.spotifyapp.modules.search.view.SearchFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val tokenManager: TokenManager by inject()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        if (tokenManager.isToken().not()) {
            authorization()
        }
    }

    private fun authorization() {
        binding.vLoading.show()
        val builder = AuthorizationRequest.Builder(
                CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI
        )
        val request = builder.build()
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, intent)
            Timber.d(response.code)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    saveToken(response)
                    openSearch()
                }
                AuthorizationResponse.Type.ERROR -> {
                    Timber.d(response.error)
                }
                else -> {
                    Timber.d(response.error)
                }
            }
            binding.vLoading.hide()
        }
    }

    private fun openSearch() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.vContainerFrag, SearchFragment())
                .commit()
    }

    private fun saveToken(response: AuthorizationResponse) {
        tokenManager.setTokens(response.accessToken)
        Timber.d(response.accessToken)
    }

    companion object {
        const val REQUEST_CODE = 1337
        const val REDIRECT_URI = "bedsus://spotifyapp"
        const val CLIENT_ID = "ae73e5bd5b6b4f04bbda7f9afaba4080"
    }

}