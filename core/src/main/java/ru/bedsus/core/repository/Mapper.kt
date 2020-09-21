package ru.bedsus.core.repository

interface Mapper<I, O> {
    fun map(input: I): O
}

fun <I, O> Mapper<I, O>.listMap(
    input: List<I>?,
    predicate: (I) -> Boolean = { true }
): List<O> {
    return input?.filter(predicate)
        ?.map { map(it) }
        .orEmpty()
}