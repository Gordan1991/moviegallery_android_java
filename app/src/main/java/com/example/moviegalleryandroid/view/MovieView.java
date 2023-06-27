package com.example.moviegalleryandroid.view;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviegalleryandroid.MainActivity;
import com.example.moviegalleryandroid.controller.MovieController;
import com.example.moviegalleryandroid.rvadapter.RVPopularMovieListAdapter;

public class MovieView {
   private MovieController controller;
   RecyclerView rv_popularMovieList;
   RVPopularMovieListAdapter rvPopularMovieListAdapter;
   Context context;


   public MovieView(MovieController controller, RecyclerView rv_popularMovieList, Context context){
      this.controller = controller;
      this.rv_popularMovieList = rv_popularMovieList;
      this.rvPopularMovieListAdapter = new RVPopularMovieListAdapter(context, controller.getPopularMovieList());
      this.context = context;

      LinearLayoutManager layoutManager = new LinearLayoutManager(rv_popularMovieList.getContext());
      rv_popularMovieList.setLayoutManager(layoutManager);
      rv_popularMovieList.setAdapter(rvPopularMovieListAdapter);
   }

   //TODO: Add View
   public void displayMovieData(){

      Log.e("MovieController","onResponse data: " + controller.getPopularMovieList().size());
      rvPopularMovieListAdapter.notifyDataSetChanged();
//      rv_popularMovieList.setLayoutManager(new LinearLayoutManager(context));
//      rvPopularMovieListAdapter =  new RVPopularMovieListAdapter(context, controller.getModel().getResults());
//      rv_popularMovieList.setAdapter(rvPopularMovieListAdapter);
//      rvPopularMovieListAdapter.notifyDataSetChanged();


   }
}
