package com.nrg.hilttest.repositories

import com.nrg.hilttest.data.remote.PokeApi
import com.nrg.hilttest.data.remote.responses.Pokemon
import com.nrg.hilttest.data.remote.responses.PokemonList
import com.nrg.hilttest.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: java.lang.Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemon(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name)
        } catch (e: java.lang.Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}
