package com.example.moviegalleryandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviegalleryandroid.model.MovieDetailModel;
import com.example.moviegalleryandroid.model.MovieModel;
import com.example.moviegalleryandroid.service.ApiClient;
import com.example.moviegalleryandroid.service.ApiMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    private String movieId = "";
    private TextView tv_movieDetail_title, tv_movieDetail_release_date;
    private ImageView iv_movieDetail_img;
    private Toolbar toolbar;
    private ProgressBar loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Movie Detail");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadingBar = findViewById(R.id.loadingBar);


        tv_movieDetail_title = findViewById(R.id.tv_movieDetail_title);
        tv_movieDetail_release_date = findViewById(R.id.tv_movieDetail_release_date);
        iv_movieDetail_img = findViewById(R.id.iv_movieDetail_img);

        movieId = getIntent().getExtras().getString("movieId");
        fetchMovieDetailData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void fetchMovieDetailData(){
        ApiMethod movieMethod = ApiClient.getApiClientInstance().create(ApiMethod.class);
        Call<MovieDetailModel> call = movieMethod.getMovieDetailData(Integer.parseInt(movieId));

        call.enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {
                Log.e("fetchMovieDetailData","onResponse Code: " + response.code());

                if(response.code() == 200){
                    loadingBar.setVisibility(View.GONE);

                    tv_movieDetail_title.setText(response.body().getTitle());
                    tv_movieDetail_release_date.setText("Release Date : " + response.body().getRelease_date());
                    Glide.with(MovieDetailActivity.this).load("https://image.tmdb.org/t/p/w500/"+ response.body().getPoster_path()).into(iv_movieDetail_img);

                }



            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                Log.e("fetchMovieDetailData","onFailure Code: " + t.getMessage());

            }
        });
    }
}