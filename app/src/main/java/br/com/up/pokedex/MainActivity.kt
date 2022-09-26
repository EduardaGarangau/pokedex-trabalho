package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapters.PokeAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerPokemon : RecyclerView =
            findViewById(R.id.recycler_pokemon)

        recyclerPokemon.layoutManager =
            GridLayoutManager(this, 2)


        recyclerPokemon.adapter = PokeAdapter(listOf())
    }
}