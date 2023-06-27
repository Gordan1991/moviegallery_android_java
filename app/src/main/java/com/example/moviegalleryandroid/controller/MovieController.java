package com.example.moviegalleryandroid.controller;

import android.util.Log;

import com.example.moviegalleryandroid.model.MovieModel;
import com.example.moviegalleryandroid.rvadapter.RVPopularMovieListAdapter;
import com.example.moviegalleryandroid.service.ApiClient;
import com.example.moviegalleryandroid.service.ApiMethod;
import com.example.moviegalleryandroid.view.MovieView;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieController {
   private ArrayList<MovieModel.resultsData> popularMovieList = new ArrayList<>();
   private RVPopularMovieListAdapter rvPopularMovieListAdapter;

   private MovieView view;

   public MovieController(RVPopularMovieListAdapter rvPopularMovieListAdapter){
      this.rvPopularMovieListAdapter = rvPopularMovieListAdapter;
   }

   public void setPopularMovieList(ArrayList<MovieModel.resultsData> popularMovieList) {
      this.popularMovieList = popularMovieList;
   }

   public ArrayList<MovieModel.resultsData> getPopularMovieList() {
      return popularMovieList;
   }

   public void fetchPopularMovieData(){
      ApiMethod movieMethod = ApiClient.getApiClientInstance().create(ApiMethod.class);
      Call<MovieModel> call = movieMethod.getAllMoviePopularData();

      call.enqueue(new Callback<MovieModel>() {
         @Override
         public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
            Log.e("MovieController","onResponse Code: " + response.code());

            if(response.code() == 200){
               ArrayList<MovieModel.resultsData> resultData = new ArrayList<MovieModel.resultsData>();
               resultData.addAll(response.body().getResults());
               setPopularMovieList(resultData);
               //rvPopularMovieListAdapter.notifyDataSetChanged();
//               model.setResults(resultData);
//               view.displayMovieData();

            }



         }

         @Override
         public void onFailure(Call<MovieModel> call, Throwable t) {
            Log.e("MovieController","onFailure Code: " + t.getMessage());

         }
      });
   }
}
