package com.example.retrofitdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements ApiResponseHandler {

    private TextView txt_title, txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_title = findViewById(R.id.txt_title);
        txt_email = findViewById(R.id.txt_email);
        JsonClassAPi classAPi = RetrofitService.api;

        Call<List<PostModel>> call1 = classAPi.getTitle();
        Call<List<CommentsModel>> call2 = classAPi.getEmail();

        new ResponseJavaClass().executeApi(this, call1);
        new ResponseJavaClass().executeApi(this, call2);

 /*       call1.enqueue(new Callback<List<PostModel>>() {
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
        });*/

    }

    @Override
    public void onResponse(Object response) {
        if (response instanceof List<PostModel>) {
            List<PostModel> postModel = (List<PostModel>) response;
            txt_title.setText(postModel.get(0).title);
        }
        else if (response instanceof List<CommentsModel>) {
            List<CommentsModel> model = (List<CommentsModel>) response;
            txt_email.setText(model.get(0).email);
        }
    }

    @Override
    public void onFailure(Object error) {

    }
}