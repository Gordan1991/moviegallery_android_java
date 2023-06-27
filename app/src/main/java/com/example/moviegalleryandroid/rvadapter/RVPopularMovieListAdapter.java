package com.example.moviegalleryandroid.rvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviegalleryandroid.R;
import com.example.moviegalleryandroid.model.MovieModel;

import java.util.ArrayList;

public class RVPopularMovieListAdapter extends RecyclerView.Adapter<RVPopularMovieListAdapter.ViewHolder> {

   Context context;
   ArrayList<MovieModel.resultsData> popularMovieList;

   public RVPopularMovieListAdapter(Context mContext, ArrayList<MovieModel.resultsData> mPopularMovieList) {
      this.context = mContext;
      this.popularMovieList = mPopularMovieList;
   }

   @NonNull
   @Override
   public RVPopularMovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.rv_popularmovielistlayout,parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull RVPopularMovieListAdapter.ViewHolder holder, int position) {
         holder.bind(popularMovieList.get(position));
   }

   @Override
   public int getItemCount() {
      return popularMovieList.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {

      private TextView tv_movie_title, tv_movie_release_date;
      private ImageView iv_movie_img;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);
         tv_movie_title = itemView.findViewById(R.id.tv_movie_title);
         tv_movie_release_date = itemView.findViewById(R.id.tv_movie_release_date);
         iv_movie_img = itemView.findViewById(R.id.iv_movie_img);
      }

      public void bind(MovieModel.resultsData resultData){
         tv_movie_title.setText(resultData.getTitle());
         tv_movie_release_date.setText(resultData.getRelease_date());
         Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+ resultData.getPoster_path()).into(iv_movie_img);
      }
   }
}
