package com.example.retrofitdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        final TextView txt_title = findViewById(R.id.txt_title);
        final TextView txt_email = findViewById(R.id.txt_email);
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
                if (model != null && model.size() > 0)
                    txt_title.setText(model.get(0).title);

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

        call2.enqueue(new Callback<List<CommentsModel>>() {
            @Override
            public void onResponse(Call<List<CommentsModel>> call, Response<List<CommentsModel>> response) {
                List<CommentsModel> model = response.body();
                if (model != null && model.size() > 0)
                    txt_email.setText(model.get(0).email);
            }

            @Override
            public void onFailure(Call<List<CommentsModel>> call, Throwable t) {

            }
        });

    }
}