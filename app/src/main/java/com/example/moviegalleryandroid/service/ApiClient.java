package com.example.moviegalleryandroid.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

   private static Retrofit retrofit;
   private static String baseUrl = "https://api.themoviedb.org/3/";

   public static Retrofit getApiClientInstance(){

      if(retrofit == null){

         OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                 .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                       Request original = chain.request();

                       Request request = original.newBuilder()
                               .header("accept", "application/json")
                               .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MmM5ZjJmMjBmZThjNzIzOTJmOTZjNjQwYzVjOGQ5YSIsInN1YiI6IjY0OTVhNTEzZDVmZmNiMDBhZDg1MDY3OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8fUCYS4ohl34KdhUlD29BC6gqNtsXUILoMb2tEf9fH0")
                               .method(original.method(), original.body())
                               .build();

                       return chain.proceed(request);
                    }
                 });


          retrofit = new Retrofit.Builder()
                 .baseUrl(baseUrl)
                  .client(httpClient.build())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
      }

      return retrofit;

   }

}
