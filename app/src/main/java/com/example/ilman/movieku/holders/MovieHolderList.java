package com.example.ilman.movieku.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilman.movieku.R;
import com.example.ilman.movieku.models.MovieLists;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.ilman.movieku.config.Constant.URL_BASE_IMAGE;

/**
 * Created by ilman on 24/05/2017.
 */

public class MovieHolderList extends RecyclerView.ViewHolder {

    @BindView(R.id.title_card)TextView title;
    @BindView(R.id.poster_card)ImageView poster;
    @BindView(R.id.year_card)TextView year;
    private Context context;

    public MovieHolderList(View itemView,Context context) {
        super(itemView);
        this.context=context;
        ButterKnife.bind(this, itemView);
    }

    public void updateUI(MovieLists movieLists){
        final String URL_IMAGE = "http://image.tmdb.org/t/p/w500"+movieLists.getPosterPath();

        title.setText(movieLists.getTitle());
        Picasso.with(context).load(URL_IMAGE).into(poster);
        year.setText(movieLists.getReleaseDate());

    }



}
