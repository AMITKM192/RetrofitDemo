package com.example.retrofitdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseJavaClass<T> {
    void executeApi(final ApiResponseHandler data, Call<T> call) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                data.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                data.onFailure(t);
            }
        });
    }
}
