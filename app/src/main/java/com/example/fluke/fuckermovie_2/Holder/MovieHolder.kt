package com.example.fluke.fuckermovie_2.Holder

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie_2.DetailActivity
import com.example.fluke.fuckermovie_2.R
import com.example.fluke.fuckermovie_2.model.Movie
import org.parceler.Parcels
import java.io.Serializable

class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val iv: ImageView
    private val tv: TextView
    private val rt_bar: RatingBar

    init {
        iv = view.findViewById(R.id.iv_movie)
        tv = view.findViewById(R.id.tv_name)
        rt_bar = view.findViewById(R.id.rt_bar)
    }

    fun onBind(movieData: Movie, context: Context) {
        tv.text = movieData.title
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + movieData.poster).into(iv)
        rt_bar.rating = java.lang.Float.parseFloat(movieData.vote_average) / 2
        Log.e("pic", movieData.vote_average)
        view.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("แจ้งเตือน")
                    .setMessage("คุณต้องการเข้าชมรายฃะเอียดใช่ปะ")
                    .setPositiveButton(android.R.string.yes) { dialog, which ->
                        val s = Intent(view.context, DetailActivity::class.java)
                        val p : Parcelable = Parcels.wrap(movieData)
                        s.putExtra("WTF_OBJ", Parcels.wrap(movieData))
                        view.context.startActivity(s)
                    }
                    .setNegativeButton(android.R.string.no) { dialog, which -> }.setIcon(android.R.drawable.ic_dialog_alert).show()
        }

    }
}
