package com.example.moviegalleryandroid.controller;

import android.util.Log;

import com.example.moviegalleryandroid.model.MovieModel;
import com.example.moviegalleryandroid.service.ApiClient;
import com.example.moviegalleryandroid.service.ApiMethod;
import com.example.moviegalleryandroid.view.MovieView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieController {
   private MovieModel model;
   private MovieView view;

   public MovieController(MovieModel model, MovieView view){
      this.model = model;
      this.view = view;
   }

   public void fetchPopularMovieData(){
      ApiMethod movieMethod = ApiClient.getApiClientInstance().create(ApiMethod.class);
      Call<MovieModel> call = movieMethod.getAllMoviePopularData();

      call.enqueue(new Callback<MovieModel>() {
         @Override
         public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
            Log.e("MovieController","onResponse Code: " + response.code());

            ArrayList<MovieModel.resultsData> resultData = response.body().getResults();

            for(MovieModel.resultsData data : resultData){
               Log.e("MovieController","onResponse result: " + data.getId());

            }

         }

         @Override
         public void onFailure(Call<MovieModel> call, Throwable t) {
            Log.e("MovieController","onFailure Code: " + t.getMessage());

         }
      });
   }
}
