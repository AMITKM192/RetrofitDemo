package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.btn);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonClassAPi classAPi = retrofit.create(JsonClassAPi.class);
        Call<List<PostModel>> call1 = classAPi.getTitle();
        Call<List<CommentsModel>> call2 = classAPi.getEmail();

        call1.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                List<PostModel> model = response.body();
                Toast.makeText(MainActivity.this, model.get(0).title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

        call2.enqueue(new Callback<List<CommentsModel>>() {
            @Override
            public void onResponse(Call<List<CommentsModel>> call, Response<List<CommentsModel>> response) {
                List<CommentsModel> model = response.body();
                Toast.makeText(MainActivity.this, model.get(0).email, Toast.LENGTH_SHORT).show();
                button.setText(model.get(0).email);
            }

            @Override
            public void onFailure(Call<List<CommentsModel>> call, Throwable t) {

            }
        });

    }
}