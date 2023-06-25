package com.example.moviegalleryandroid.service;

import com.example.moviegalleryandroid.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiMethod {
 @GET("discover/movie?")
 Call<MovieModel> getAllMoviePopularData();

}
