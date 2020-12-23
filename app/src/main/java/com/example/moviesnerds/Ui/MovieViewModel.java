package com.example.moviesnerds.Ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesnerds.pojo.MovieModel;

public class MovieViewModel extends ViewModel {
    MutableLiveData<String> movieNameMutableLiveData = new MutableLiveData<>();

    public void getMovieName() {
        String movieName = getMovieFromDatabase().getName();
        movieNameMutableLiveData.setValue(movieName);
    }

    private MovieModel getMovieFromDatabase() {
        return new MovieModel("cast away", "21-9-1996", "very sad movie", 1);
    }

}
