package ru.bedsus.core.token

/**
 * Работа с токеном доступа.
 */
interface TokenManager {

    val accessToken: String

    fun isToken(): Boolean

    fun setTokens(accessToken: String)

    fun invalidateTokens()
}