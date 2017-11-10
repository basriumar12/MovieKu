package com.example.ilman.movieku.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ilman.movieku.R;
import com.example.ilman.movieku.activities.MainActivity;
import com.example.ilman.movieku.holders.MovieHolderList;
import com.example.ilman.movieku.models.MovieLists;

import java.util.ArrayList;

/**
 * Created by ilman on 24/05/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieHolderList>{

    private ArrayList<MovieLists>  mMovieListModels;
    private static String URL_MOVE_ID_SEND = null;
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }


    public MovieAdapter(ArrayList<MovieLists> mMovieListModels) {
        this.mMovieListModels = mMovieListModels;
    }

    public static String getUrlMoveIdSend() {
        return URL_MOVE_ID_SEND;
    }

    public static void setUrlMoveIdSend(String urlMoveIdSend) {
        URL_MOVE_ID_SEND = urlMoveIdSend;
    }


    @Override
    public MovieHolderList onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movie,parent,false);
        return new MovieHolderList(card, parent.getContext());
    }

    @Override
    public void onBindViewHolder(final MovieHolderList holder, int position) {
        final MovieLists movieLists = mMovieListModels.get(position);

        final String URL_BASE = "https://api.themoviedb.org/3/";
        final String URL_SEARCH_ID = "movie/";
        final String URL_API_KEY = "&api_key=2bea38317c7da072ccff5b9ad2bcc5a2";

        holder.updateUI(movieLists);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"ONCLICK TOAST",Toast.LENGTH_SHORT).show();

                MainActivity.getMainActivity().loadDetailMovie(movieLists);

                String URL_MOVIE_BY_ID = URL_BASE + URL_SEARCH_ID +movieLists.getId() +"?" + URL_API_KEY + "&append_to_response=videos";
                setUrlMoveIdSend(URL_MOVIE_BY_ID);

//                Toast.makeText(view.getContext(),URL_MOVIE_BY_ID,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovieListModels.size();
    }
}
