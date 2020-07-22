package com.example.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonClassAPi {
    @GET("posts")
    Call<List<PostModel>> getTitle();

    @GET("comments")
    Call<List<CommentsModel>> getEmail();
}
