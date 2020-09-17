package ru.bedsus.core.token

import android.content.SharedPreferences

class TokenManagerImpl(
    private val preferences: SharedPreferences
) : TokenManager {

    override val accessToken: String
        get() = preferences.getString(ACCESS_TOKEN_TAG, "") ?: ""

    override fun isToken(): Boolean {
        return accessToken.isNotEmpty()
    }

    override fun setTokens(accessToken: String) {
        preferences.edit()
            .putString(ACCESS_TOKEN_TAG, accessToken)
            .apply()
    }

    override fun invalidateTokens() {
        preferences.edit()
            .remove(ACCESS_TOKEN_TAG)
            .apply()
    }

    private companion object {
        const val ACCESS_TOKEN_TAG = "ACCESS_TOKEN_TAG"
    }
}