package com.example.fluke.fuckermovie2.moviedetail.holder

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.fluke.fuckermovie2.MainActivity
import com.example.fluke.fuckermovie2.load
import com.example.fluke.fuckermovie2.moviedetail.model.YouVidData
import kotlinx.android.synthetic.main.fucktube_item.view.*

class YoutubeVidHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(youVidData: YouVidData) {
        Log.e("check value ", youVidData.listData.title)
        view.tv_youtube.text = youVidData.listData.title
        view.iv_youtube load MainActivity.POSTER_VID + "${youVidData.id.videoId}/mqdefault.jpg"
        view.setOnClickListener {
            view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youVidData.id.videoId)))
        }
    }
}
