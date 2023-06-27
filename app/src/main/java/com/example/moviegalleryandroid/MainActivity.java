package com.example.moviegalleryandroid;

import android.os.Bundle;
import android.util.Log;

import com.example.moviegalleryandroid.controller.MovieController;
import com.example.moviegalleryandroid.model.MovieModel;
import com.example.moviegalleryandroid.rvadapter.RVPopularMovieListAdapter;
import com.example.moviegalleryandroid.service.ApiClient;
import com.example.moviegalleryandroid.service.ApiMethod;
import com.example.moviegalleryandroid.view.MovieView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_popularMovieList;
    RVPopularMovieListAdapter rvPopularMovieListAdapter;

    ArrayList<MovieModel.resultsData> popularMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popularMovieList = new ArrayList<>();

        rv_popularMovieList = findViewById(R.id.rv_popularmovielist);
        rv_popularMovieList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvPopularMovieListAdapter =  new RVPopularMovieListAdapter(MainActivity.this, popularMovieList);
        rv_popularMovieList.setAdapter(rvPopularMovieListAdapter);

        //MovieModel movieModel = new MovieModel();
        //MovieView movieView = new MovieView(movieController);
        //movieController = new MovieController(movieModel, movieView);

        // Trigger API data retrieval
        //movieController.fetchPopularMovieData();
        fetchPopularMovieData();


    }

    public void fetchPopularMovieData(){
        ApiMethod movieMethod = ApiClient.getApiClientInstance().create(ApiMethod.class);
        Call<MovieModel> call = movieMethod.getAllMoviePopularData();

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                Log.e("MovieController","onResponse Code: " + response.code());

                if(response.code() == 200){
                    popularMovieList.addAll(response.body().getResults());
                    rvPopularMovieListAdapter.notifyDataSetChanged();
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