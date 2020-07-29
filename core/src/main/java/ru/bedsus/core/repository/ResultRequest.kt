package ru.bedsus.core.repository

sealed class ResultRequest<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultRequest<T>()
    data class Error(val exception: Exception) : ResultRequest<Nothing>()
    object Loading : ResultRequest<Nothing>()
}