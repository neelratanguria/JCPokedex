package com.nrg.hilttest.ui.ViewModels

import androidx.lifecycle.ViewModel
import com.nrg.hilttest.data.remote.responses.Pokemon
import com.nrg.hilttest.repositories.PokemonRepository
import com.nrg.hilttest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        return repository.getPokemon(pokemonName)
    }
}