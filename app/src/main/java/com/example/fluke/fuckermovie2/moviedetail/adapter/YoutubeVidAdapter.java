package com.example.fluke.fuckermovie2.moviedetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluke.fuckermovie2.R;
import com.example.fluke.fuckermovie2.moviedetail.holder.YoutubeVidHolder;
import com.example.fluke.fuckermovie2.moviedetail.model.YouVidData;

import java.util.ArrayList;


public class YoutubeVidAdapter extends RecyclerView.Adapter {

    private ArrayList<YouVidData> dataList;
    private Context context;

    public YoutubeVidAdapter(ArrayList<YouVidData> dataList, Context context) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setItems(ArrayList<YouVidData> movieList) {
        dataList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fucktube_item, parent, false);
        return new YoutubeVidHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        YoutubeVidHolder youtubeVidHolder = (YoutubeVidHolder) holder;
        youtubeVidHolder.onBind(dataList.get(position), context);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
