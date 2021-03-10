package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab_4.models.Pokemons;
import com.example.lab_4.retrofit.PokemonAPI;
import com.example.lab_4.retrofit.Retrofit2;
import com.google.gson.JsonObject;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btn_buscar;
    EditText et_nombre;
    TextView tvNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_buscar = findViewById(R.id.btn_buscar);
        et_nombre = findViewById(R.id.et_nombre);
        tvNombre = findViewById(R.id.tvNombre);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                find(et_nombre.getText().toString());

            }
        });




    }

    private void find(String codigo){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        PokemonAPI pokemonAPI = retrofit.create(PokemonAPI.class);
        Call<Pokemons> call = pokemonAPI.find(codigo);
        call.enqueue(new Callback<Pokemons>() {
            @Override
            public void onResponse(Call<Pokemons> call, Response<Pokemons> response) {
                try{
                    if(response.isSuccessful()){
                        Pokemons p = response.body();
                        String URL_IMG = "https://pokeapi.co/api/v2/img/"+p.getName()+".jpg";
                        tvNombre.setText(p.getName());
                    }
                }
                catch(Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Pokemons> call, Throwable t) {

            }
        });
    }


}




