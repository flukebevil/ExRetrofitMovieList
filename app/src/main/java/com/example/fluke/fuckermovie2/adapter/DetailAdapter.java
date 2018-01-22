package com.example.fluke.fuckermovie2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluke.fuckermovie2.holder.MovieHolder;
import com.example.fluke.fuckermovie2.R;
import com.example.fluke.fuckermovie2.model.Movie;

import java.util.ArrayList;


public class DetailAdapter extends RecyclerView.Adapter {

    private ArrayList<Movie> dataList;
    private Context context;

    public DetailAdapter(ArrayList<Movie> dataList, Context context) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setItems(ArrayList<Movie> movieList) {
        dataList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.muuvee_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieHolder) {
            MovieHolder movieHolder = (MovieHolder) holder;
            movieHolder.onBind(dataList.get(position), context);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
