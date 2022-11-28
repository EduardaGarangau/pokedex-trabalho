package br.com.up.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapters.PokeAdapter
import br.com.up.pokedex.extensions.id
import br.com.up.pokedex.models.Pokemon
import br.com.up.pokedex.models.PokemonType
import br.com.up.pokedex.network.PokeApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerPokemon : RecyclerView =
            findViewById(R.id.recycler_pokemon)

        recyclerPokemon.layoutManager =
            GridLayoutManager(this, 2)

        PokeApi().pokemons{ pokemons->
            recyclerPokemon.adapter = PokeAdapter(pokemons!!)
            { pokemon ->
                callPokemonDetail(pokemon)
            }
        }
    }

    fun callPokemonDetail(pokemon:Pokemon){

        val intent = Intent(
            this,
            PokemonDetails::class.java)
        intent.putExtra("pokemonId",pokemon.id())
        startActivity(intent)
    }

}