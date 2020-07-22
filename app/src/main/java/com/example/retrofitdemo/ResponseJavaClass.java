package com.example.retrofitdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseJavaClass<T> {
    void enqueueCallBack(final ApiResponseHandler data, Call<T> call) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                data.onResponse(response.body());
              /*  T model = response.body();
                if (model != null && model.size() > 0)
                    txt_title.setText(model.get(0).title);*/

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                data.onFailure(t);
            }
        });
    }
}
