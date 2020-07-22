package com.example.retrofitdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ApiResponseHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt_title = findViewById(R.id.txt_title);
        final TextView txt_email = findViewById(R.id.txt_email);
        JsonClassAPi classAPi = RetrofitService.api;

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

    @Override
    public void onResponse(Object o) {

    }

    @Override
    public void onFailure(Object o) {

    }
}