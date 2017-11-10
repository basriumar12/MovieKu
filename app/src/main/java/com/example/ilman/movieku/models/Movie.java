package com.example.ilman.movieku.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ilman on 25/05/2017.
 */

public class Movie {
    private String title;
    private String posterPath;
    private String releaseDate;
    private int runtime;
    private String voteAverage;
    private String overview;
    private String trailer;

    public Movie(String title, String posterPath, String releaseDate, int runtime, String voteAverage, String overview) {
        this.title = title;
        this.posterPath = posterPath;
        setReleaseDate(releaseDate);
        this.runtime = runtime;
        this.voteAverage = voteAverage;
        this.overview = overview;
    }


    public void setReleaseDate(String releaseDate) {
        SimpleDateFormat formatDefault = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");

        try {
            Date YearFormat = formatDefault.parse(releaseDate);
            releaseDate = formatYear.format(YearFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.releaseDate = releaseDate;
    }

    public Movie(String trailer) {
        this.trailer = trailer;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getTrailer() {
        return trailer;
    }
}
