package com.nrg.hilttest.data.remote

import com.nrg.hilttest.data.remote.responses.Pokemon
import com.nrg.hilttest.data.remote.responses.PokemonList
import com.nrg.hilttest.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ) : Pokemon
}