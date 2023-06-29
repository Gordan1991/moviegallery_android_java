package com.example.moviegalleryandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.moviegalleryandroid.model.MovieModel;
import com.example.moviegalleryandroid.rvadapter.RVMovieListAdapter;
import com.example.moviegalleryandroid.service.ApiClient;
import com.example.moviegalleryandroid.service.ApiMethod;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchMovieListActivity extends AppCompatActivity {
    private RecyclerView rv_searchMovieList;
    private RVMovieListAdapter rvMovieListAdapter;
    private ArrayList<MovieModel.resultsData> searchMovieList;
    private Toolbar toolbar;

    private String searchMovie = "";
    private ProgressBar loadingBar;

    private TextView tv_searchMovieHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie_list);
        searchMovieList = new ArrayList<>();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Search Movie");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_searchMovieHeader = findViewById(R.id.tv_searchMovieHeader);

        loadingBar = findViewById(R.id.loadingBar);

        rv_searchMovieList = findViewById(R.id.rv_searchmovielist);
        rv_searchMovieList.setLayoutManager(new LinearLayoutManager(SearchMovieListActivity.this));
        rvMovieListAdapter =  new RVMovieListAdapter(SearchMovieListActivity.this, searchMovieList);
        rv_searchMovieList.setAdapter(rvMovieListAdapter);

        // Trigger API data retrieval
        searchMovie = getIntent().getExtras().getString("searchMovie");
        tv_searchMovieHeader.setText("Search Results : " + searchMovie);
        fetchSearchMovieData(searchMovie);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void fetchSearchMovieData(String searchMovie){
        ApiMethod movieMethod = ApiClient.getApiClientInstance().create(ApiMethod.class);
        Call<MovieModel> call = movieMethod.getSearchMovieListData(searchMovie);

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                Log.e("fetchSearchMovieData","onResponse Code: " + response.code());

                if(response.code() == 200){
                    searchMovieList.addAll(response.body().getResults());
                    rvMovieListAdapter.notifyDataSetChanged();
                    loadingBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.e("fetchSearchMovieData","onFailure Code: " + t.getMessage());

            }
        });
    }
}