package com.example.lab_4.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 {

    final private PokemonAPI urls;

    public Retrofit2(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.URL_BASE)
                .addConverterFactory((GsonConverterFactory.create()))
                .build();
        urls = retrofit.create(PokemonAPI.class);
    }

    public PokemonAPI getService(){return urls;}

}



