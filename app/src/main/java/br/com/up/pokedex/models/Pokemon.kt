package br.com.up.pokedex.models

data class Pokemon(
    var name: String,
    var url: String,
    var types: List<PokemonType>,
    var abilities: List<PokeAbility>,
    var moves: List<PokeMoves>,
    var stats: List<PokeStats>
)
