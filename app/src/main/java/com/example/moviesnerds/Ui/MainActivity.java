package com.example.moviesnerds.Ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.moviesnerds.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.textView)
    TextView movieNameTextView;
    @BindView(R.id.button)
    Button getMovieButton;
    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMovieButton.setOnClickListener(this);

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.movieNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                movieNameTextView.setText(s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            movieViewModel.getMovieName();
        }
    }
}