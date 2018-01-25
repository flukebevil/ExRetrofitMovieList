package com.example.fluke.fuckermovie2.holder

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie2.BuildConfig
import com.example.fluke.fuckermovie2.moviedetail.DetailActivity
import com.example.fluke.fuckermovie2.MainActivity
import com.example.fluke.fuckermovie2.model.Movie
import kotlinx.android.synthetic.main.muuvee_item.view.*
import org.parceler.Parcels

class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        const val SHOW_DETAIL_KEY = "WTF_OBJ"
    }

    fun onBind(movieData: Movie) {
        view.tv_name.text = movieData.title
        Glide.with(itemView.context).load(MainActivity.PICK_LINK + movieData.poster).into(view.iv_movie)
        view.rt_bar.rating = java.lang.Float.parseFloat(movieData.vote_average).div(2)
        if (BuildConfig.DEBUG) Log.e("pic", movieData.vote_average)
        view.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("แจ้งเตือน")
                    .setMessage("คุณต้องการเข้าชมรายฃะเอียดใช่ปะ")
                    .setPositiveButton(android.R.string.yes) { _, _ ->
                        view.context.startActivity(Intent(view.context, DetailActivity::class.java)
                                .apply { putExtra(SHOW_DETAIL_KEY, Parcels.wrap(movieData)) })
                    }
                    .setNegativeButton(android.R.string.no) { _, _ -> }.setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }
}
