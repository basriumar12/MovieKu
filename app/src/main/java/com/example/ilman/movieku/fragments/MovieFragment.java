package com.example.ilman.movieku.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ilman.movieku.R;
import com.example.ilman.movieku.adapters.MovieAdapter;
import com.example.ilman.movieku.config.Constant;
import com.example.ilman.movieku.models.MovieLists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class MovieFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<MovieLists> mMovieLists = new ArrayList<>();

    MovieAdapter movieAdapter;

    public MovieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this,v);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycleid);
        movieAdapter = new MovieAdapter(mMovieLists);
        recyclerView.setAdapter(movieAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constant.FULL_API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //                    JSONArray movieArray = response.getJSONArray("results");
                try {
                    JSONArray array = response.getJSONArray("results");

                    for (int i = 0; i<10;i++){
                        JSONObject object= array.getJSONObject(i);
                        String poster_path = object.getString("poster_path");
                        String title = object.getString("title");

                        String overview = object.getString("overview");
                        String voteAvarage = object.getString("vote_average");
                        String id = object.getString("id");
                        String releaseDate = object.getString("release_date");

                        Log.d("asd",poster_path);
                        System.out.println("COBA= "+poster_path);

                        MovieLists movieLists =  new MovieLists(poster_path,title,releaseDate,voteAvarage,overview,id);
                        mMovieLists.add(movieLists);
                        movieAdapter.notifyDataSetChanged();
                    }

                    Log.d("Results",array.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.getMessage());
            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);

        return v;
    }
}
