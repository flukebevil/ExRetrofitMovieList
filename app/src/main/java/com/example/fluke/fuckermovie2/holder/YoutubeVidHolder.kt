package com.example.fluke.fuckermovie2.holder

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie2.model.YouVidData
import kotlinx.android.synthetic.main.fucktube_item.view.*

class YoutubeVidHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        val SHOWDETAIL_KEY = "WTF_OBJ"
    }

    fun onBind(youVidData: YouVidData, context: Context) {
        Log.e("check value ", youVidData.listData.title)
        view.tv_youtube.setText(youVidData.listData.title)
        Glide.with(context).load("https://i.ytimg.com/vi/${youVidData.id.videoId}/mqdefault.jpg").into(view.iv_youtube)
        view.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youVidData.id.videoId))
            view.context.startActivity(intent)
        }
    }
}
