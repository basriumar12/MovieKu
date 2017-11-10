package com.example.ilman.movieku.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilman.movieku.R;
import com.example.ilman.movieku.fragments.DetailMovieFragment;
import com.example.ilman.movieku.fragments.MovieFragment;
import com.example.ilman.movieku.models.MovieLists;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MovieFragment movieFragment = (MovieFragment) fragmentManager.findFragmentById(R.id.main_frame);

        if (movieFragment == null){
            movieFragment = MovieFragment.newInstance("bebas","coba");
            fragmentManager.beginTransaction().add(R.id.main_frame, movieFragment).commit();
        }
    }

    public void loadDetailMovie(MovieLists selectedMovie){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new DetailMovieFragment())
                .addToBackStack(null).commit();
    }
}
