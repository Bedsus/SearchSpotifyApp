package ru.bedsus.spotifyapp.modules.search.user_case

object SearchUserCases {

    fun generateSearchQuery(
        query: String,
        fromYear: String?,
        toYear: String?,
        genre: String?,
    ): String {
        var resultQuery = query
        if (fromYear != null && toYear != null && fromYear.isNotEmpty() && toYear.isNotEmpty()) {
            resultQuery += " year:$fromYear-$toYear"
        } else if (fromYear != null && fromYear.isNotEmpty()) {
            resultQuery += " year:$fromYear"
        }
        if (genre != null && genre.isNotEmpty()) {
            resultQuery += " genre:$genre"
        }
        return resultQuery
    }
}