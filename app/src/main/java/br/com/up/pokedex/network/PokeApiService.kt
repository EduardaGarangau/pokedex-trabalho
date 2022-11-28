package br.com.up.pokedex.network

import br.com.up.pokedex.models.PokeApiResponse
import br.com.up.pokedex.models.Pokemon
import br.com.up.pokedex.models.PokemonType
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon?limit=151")
    fun getPokemons(): Call<PokeApiResponse>

    @GET("pokemon/{id}")
    fun getPokemonById(@Path(value="id") id:String): Call<Pokemon>

    @GET("pokemon/{name}")
    fun getPokemonByName(@Path(value="name") name:String): Call<Pokemon>

    @GET("pokemon/{id}")
    fun getPokemonTypes(@Path(value="id") id:String, @Query("types") types: String): Call<PokeApiResponse>
}