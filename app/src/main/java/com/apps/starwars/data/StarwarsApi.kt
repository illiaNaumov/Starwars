package com.apps.starwars.data

import com.squareup.moshi.JsonClass
import retrofit2.http.GET

interface StarwarsApi {
    @GET("people")
    suspend fun getPeople(): PeopleResponse
}

@JsonClass(generateAdapter = true)
class PeopleResponse(
    val count: Int = 0
)
