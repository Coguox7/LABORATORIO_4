package com.example.lab_4.retrofit;

import com.example.lab_4.models.Pokemons;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("api/pokemon/{id}")
    public Call<Pokemons> find(@Path("id") String id);

}
