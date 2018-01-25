package com.example.fluke.fuckermovie2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluke.fuckermovie2.holder.MovieHolder;
import com.example.fluke.fuckermovie2.R;
import com.example.fluke.fuckermovie2.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter {

    private List<Movie> dataList;

    public DetailAdapter(List<Movie> dataList) {
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
            movieHolder.onBind(dataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}