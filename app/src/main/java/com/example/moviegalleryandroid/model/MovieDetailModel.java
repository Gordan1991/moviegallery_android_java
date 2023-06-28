package com.example.moviegalleryandroid.model;

import java.util.ArrayList;

public class MovieDetailModel {
   String adult;
   String backdrop_path;
   BelongsToCollectionData belongs_to_collection;
   String budget;
   ArrayList<genresData> genres;
   String homepage;
   String id;
   String imdb_id;
   String original_language;
   String original_title;
   String overview;
   String popularity;
   String poster_path;
   ArrayList<productionCompaniesData> production_companies;
   ArrayList<productionCountriesData> production_countries;
   String release_date;
   String revenue;
   String runtime;
   ArrayList<spokenLanguagesData> spoken_languages;
   String status;
   String tagline;
   String title;
   String video;
   String vote_average;
   String vote_count;

   public String getAdult() {
      return adult;
   }

   public void setAdult(String adult) {
      this.adult = adult;
   }

   public String getBackdrop_path() {
      return backdrop_path;
   }

   public void setBackdrop_path(String backdrop_path) {
      this.backdrop_path = backdrop_path;
   }

   public BelongsToCollectionData getBelongs_to_collection() {
      return belongs_to_collection;
   }

   public void setBelongs_to_collection(BelongsToCollectionData belongs_to_collection) {
      this.belongs_to_collection = belongs_to_collection;
   }

   public String getBudget() {
      return budget;
   }

   public void setBudget(String budget) {
      this.budget = budget;
   }

   public ArrayList<genresData> getGenres() {
      return genres;
   }

   public void setGenres(ArrayList<genresData> genres) {
      this.genres = genres;
   }

   public String getHomepage() {
      return homepage;
   }

   public void setHomepage(String homepage) {
      this.homepage = homepage;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getImdb_id() {
      return imdb_id;
   }

   public void setImdb_id(String imdb_id) {
      this.imdb_id = imdb_id;
   }

   public String getOriginal_language() {
      return original_language;
   }

   public void setOriginal_language(String original_language) {
      this.original_language = original_language;
   }

   public String getOriginal_title() {
      return original_title;
   }

   public void setOriginal_title(String original_title) {
      this.original_title = original_title;
   }

   public String getOverview() {
      return overview;
   }

   public void setOverview(String overview) {
      this.overview = overview;
   }

   public String getPopularity() {
      return popularity;
   }

   public void setPopularity(String popularity) {
      this.popularity = popularity;
   }

   public String getPoster_path() {
      return poster_path;
   }

   public void setPoster_path(String poster_path) {
      this.poster_path = poster_path;
   }

   public ArrayList<productionCompaniesData> getProduction_companies() {
      return production_companies;
   }

   public void setProduction_companies(ArrayList<productionCompaniesData> production_companies) {
      this.production_companies = production_companies;
   }

   public ArrayList<productionCountriesData> getProduction_countries() {
      return production_countries;
   }

   public void setProduction_countries(ArrayList<productionCountriesData> production_countries) {
      this.production_countries = production_countries;
   }

   public String getRelease_date() {
      return release_date;
   }

   public void setRelease_date(String release_date) {
      this.release_date = release_date;
   }

   public String getRevenue() {
      return revenue;
   }

   public void setRevenue(String revenue) {
      this.revenue = revenue;
   }

   public String getRuntime() {
      return runtime;
   }

   public void setRuntime(String runtime) {
      this.runtime = runtime;
   }

   public ArrayList<spokenLanguagesData> getSpoken_languages() {
      return spoken_languages;
   }

   public void setSpoken_languages(ArrayList<spokenLanguagesData> spoken_languages) {
      this.spoken_languages = spoken_languages;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getTagline() {
      return tagline;
   }

   public void setTagline(String tagline) {
      this.tagline = tagline;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getVideo() {
      return video;
   }

   public void setVideo(String video) {
      this.video = video;
   }

   public String getVote_average() {
      return vote_average;
   }

   public void setVote_average(String vote_average) {
      this.vote_average = vote_average;
   }

   public String getVote_count() {
      return vote_count;
   }

   public void setVote_count(String vote_count) {
      this.vote_count = vote_count;
   }

   public class BelongsToCollectionData {
      String id;
      String name;
      String poster_path;
      String backdrop_path;
   }
   public class genresData{
      String id;
      String name;

      public String getId() {
         return id;
      }

      public void setId(String id) {
         this.id = id;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }
   }

   public class productionCompaniesData{
      String id;
      String logo_path;
      String name;
      String origin_country;

      public String getId() {
         return id;
      }

      public void setId(String id) {
         this.id = id;
      }

      public String getLogo_path() {
         return logo_path;
      }

      public void setLogo_path(String logo_path) {
         this.logo_path = logo_path;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }

      public String getOrigin_country() {
         return origin_country;
      }

      public void setOrigin_country(String origin_country) {
         this.origin_country = origin_country;
      }
   }

   public class productionCountriesData{
      String iso_3166_1;
      String name;

      public String getIso_3166_1() {
         return iso_3166_1;
      }

      public void setIso_3166_1(String iso_3166_1) {
         this.iso_3166_1 = iso_3166_1;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }
   }

   public class spokenLanguagesData{
      String english_name;
      String iso_639_1;
      String name;

      public String getEnglish_name() {
         return english_name;
      }

      public void setEnglish_name(String english_name) {
         this.english_name = english_name;
      }

      public String getIso_639_1() {
         return iso_639_1;
      }

      public void setIso_639_1(String iso_639_1) {
         this.iso_639_1 = iso_639_1;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }
   }
}
