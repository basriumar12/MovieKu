package com.example.ilman.movieku.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ilman on 24/05/2017.
 */

public class MovieLists {
    private String posterPath;
    private String title;
    private String releaseDate;
    private String voteAverage;
    private String overview;
    private String id;

    public MovieLists(String posterPath, String title) {
        this.posterPath = posterPath;
        this.title = title;
    }

    public MovieLists(String posterPath, String title, String releaseDate, String voteAverage, String overview, String id) {
        this.posterPath = posterPath;
        this.title = title;
        setReleaseDate(releaseDate);
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
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

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getId() {
        return id;
    }

}
