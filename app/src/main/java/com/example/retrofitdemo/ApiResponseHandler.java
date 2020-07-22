package com.example.retrofitdemo;

public interface ApiResponseHandler {
    void onResponse(Object o);
    void onFailure(Object o);
}
