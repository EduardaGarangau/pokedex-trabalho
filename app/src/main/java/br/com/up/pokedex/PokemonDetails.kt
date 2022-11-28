package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapters.AbilityAdapter
import br.com.up.pokedex.extensions.id
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class PokemonDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemonId = intent.getStringExtra("pokemonId")

        PokeApi().getPokemonById(pokemonId!!){
                pokemon ->

            if(pokemon != null){
                // Imagem do Pokemon
                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemonId!!}.png"
                val pokemonImage : ImageView = findViewById(R.id.pokemon_image)
                Picasso.get().load(url).into(pokemonImage)

                // Nome do Pokemon
                val pokemonName : TextView = findViewById(R.id.name_pokemon)
                pokemonName.text = pokemon.name.capitalize()

                // Tipos do Pokemon
                val pokemonType1: TextView = findViewById(R.id.pokemon_type1)
                val pokemonType2: TextView = findViewById(R.id.pokemon_type2)

                pokemonType1.text = pokemon.types[0].type.name.capitalize()

                if(pokemon.types.size > 1){
                    pokemonType2.visibility = View.VISIBLE
                    pokemonType2.text = pokemon.types[1].type.name.capitalize()
                } else {
                    pokemonType2.visibility = View.GONE
                }

                // Habilidades do Pokemon
                val pokemonAbility1: TextView = findViewById(R.id.ability_1)
                val pokemonAbility2: TextView = findViewById(R.id.ability_2)
                pokemonAbility1.text = pokemon.abilities[0].ability.name.capitalize()
                pokemonAbility2.text = pokemon.abilities[1].ability.name.capitalize()

                // Movimentos do Pokemon
                val pokemonMove1: TextView = findViewById(R.id.move_1)
                val pokemonMove2: TextView = findViewById(R.id.move_2)
                pokemonMove1.text = pokemon.moves[0].move.name.capitalize()
                pokemonMove2.text = pokemon.moves[1].move.name.capitalize()

                // Stats do Pokemon
                val pokemonHp: TextView = findViewById(R.id.hp_name)
                val pokemonHpValue: TextView = findViewById(R.id.hp_value)
                pokemonHp.text = pokemon.stats[0].stat.name.capitalize()
                pokemonHpValue.text = pokemon.stats[0].base_stat.toString()

                val pokemonAttack: TextView = findViewById(R.id.attack_name)
                val pokemonAttackValue: TextView = findViewById(R.id.attack_value)
                pokemonAttack.text = pokemon.stats[1].stat.name.capitalize()
                pokemonAttackValue.text = pokemon.stats[1].base_stat.toString()

                val pokemonDefense: TextView = findViewById(R.id.defense_name)
                val pokemonDefenseValue: TextView = findViewById(R.id.defense_value)
                pokemonDefense.text = pokemon.stats[2].stat.name.capitalize()
                pokemonDefenseValue.text= pokemon.stats[2].base_stat.toString()

                val pokemonSAttack: TextView = findViewById(R.id.special_attack_name)
                val pokemonSAttackValue: TextView = findViewById(R.id.special_attack_value)
                pokemonSAttack.text = pokemon.stats[3].stat.name.capitalize()
                pokemonSAttackValue.text= pokemon.stats[3].base_stat.toString()

                val pokemonSDefense: TextView = findViewById(R.id.special_defense_name)
                val pokemonSDefenseValue: TextView = findViewById(R.id.special_defense_value)
                pokemonSDefense.text = pokemon.stats[4].stat.name.capitalize()
                pokemonSDefenseValue.text= pokemon.stats[4].base_stat.toString()

                val pokemonSpeed: TextView = findViewById(R.id.speed_name)
                val pokemonSpeedValue: TextView = findViewById(R.id.speed_value)
                pokemonSpeed.text = pokemon.stats[5].stat.name.capitalize()
                pokemonSpeedValue.text= pokemon.stats[5].base_stat.toString()
                }
            }
        }
    }
