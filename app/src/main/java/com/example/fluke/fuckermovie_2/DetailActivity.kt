package com.example.fluke.fuckermovie_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie_2.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*
import org.parceler.Parcels

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val movie  = intent.extras.get("WTF_OBJ")
        val movies : Movie = Parcels.unwrap(movie as Parcelable?)
        Log.e("sdfasdf", movies.title)
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + movies.poster).into(mv_poster)
            tv_ecname.setText(movies.title)
        tv_detail.setText(movies.overview)
        tv_releadedate.setText(movies.release_date)

        btn_back.setOnClickListener {
            val intent : Intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}
