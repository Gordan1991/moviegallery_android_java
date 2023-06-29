package com.example.moviegalleryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.moviegalleryandroid.model.MovieModel;
import com.example.moviegalleryandroid.rvadapter.RVMovieListAdapter;
import com.example.moviegalleryandroid.service.ApiClient;
import com.example.moviegalleryandroid.service.ApiMethod;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SearchView sv_searchMovie;
    private Button btn_search;
    private RecyclerView rv_popularMovieList;
    private RVMovieListAdapter rvMovieListAdapter;

    private ArrayList<MovieModel.resultsData> popularMovieList;
    private String searchText;
    private ProgressBar loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popularMovieList = new ArrayList<>();

        sv_searchMovie = findViewById(R.id.sv_searchMovie);
        btn_search = findViewById(R.id.btn_search);
        sv_searchMovie.clearFocus();

        loadingBar = findViewById(R.id.loadingBar);

        sv_searchMovie.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                setSearchText(newText);

                return true;
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchMovieListActivity.class);
                intent.putExtra("searchMovie", getSearchText());
                MainActivity.this.startActivity(intent);
            }
        });

        rv_popularMovieList = findViewById(R.id.rv_popularmovielist);
        rv_popularMovieList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvMovieListAdapter =  new RVMovieListAdapter(MainActivity.this, popularMovieList);
        rv_popularMovieList.setAdapter(rvMovieListAdapter);

        // Trigger API data retrieval
        fetchPopularMovieData();


    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
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
                    rvMovieListAdapter.notifyDataSetChanged();
                    loadingBar.setVisibility(View.GONE);

                }



            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.e("MovieController","onFailure Code: " + t.getMessage());

            }
        });
    }

}