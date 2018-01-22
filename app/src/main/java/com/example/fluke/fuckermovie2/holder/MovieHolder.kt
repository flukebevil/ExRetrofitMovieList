package com.example.fluke.fuckermovie2.holder

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie2.DetailActivity
import com.example.fluke.fuckermovie2.MainActivity
import com.example.fluke.fuckermovie2.model.Movie
import kotlinx.android.synthetic.main.muuvee_item.view.*
import org.parceler.Parcels

class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        val SHOWDETAIL_KEY = "WTF_OBJ"
    }

    fun onBind(movieData: Movie, context: Context) {
        view.tv_name.text = movieData.title
        Glide.with(context).load(MainActivity.PICK_LINK + movieData.poster).into(view.iv_movie)
        view.rt_bar.rating = java.lang.Float.parseFloat(movieData.vote_average) / 2
        Log.e("pic", movieData.vote_average)
        view.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("แจ้งเตือน")
                    .setMessage("คุณต้องการเข้าชมรายฃะเอียดใช่ปะ")
                    .setPositiveButton(android.R.string.yes) { dialog, which ->
                        val s = Intent(view.context, DetailActivity::class.java)
                        val p: Parcelable = Parcels.wrap(movieData)
                        s.putExtra(SHOWDETAIL_KEY, Parcels.wrap(movieData))
                        view.context.startActivity(s)
                    }
                    .setNegativeButton(android.R.string.no) { dialog, which -> }.setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }
}
