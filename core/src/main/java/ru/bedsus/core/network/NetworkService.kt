package ru.bedsus.core.network

interface NetworkService {
    fun <T> create(serviceClass: Class<T>): T
}