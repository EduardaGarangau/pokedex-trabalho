package br.com.up.pokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.extensions.id
import br.com.up.pokedex.models.PokeAbility
import br.com.up.pokedex.models.Pokemon
import com.squareup.picasso.Picasso

class AbilityAdapter(private val abilityList:List<PokeAbility>, private val callback:(pokeAbility: PokeAbility) -> Unit) :
    RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {

    inner class AbilityViewHolder(item: View) :
        RecyclerView.ViewHolder(item){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityAdapter.AbilityViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val layout = inflater
            .inflate(
                R.layout.ability_item,
                parent,
                false
            )

        return AbilityViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AbilityAdapter.AbilityViewHolder, position: Int) {

        val ability = abilityList[position]

        val abilityText : TextView = holder.itemView.findViewById(R.id.pokemon_ability)
        abilityText.text = ability.ability.name

    }

    override fun getItemCount(): Int {
        return abilityList.size
    }
}