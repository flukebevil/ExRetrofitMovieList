package com.example.fluke.fuckermovie2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie2.holder.MovieHolder
import com.example.fluke.fuckermovie2.model.Movie
import com.example.fluke.fuckermovie2.precenter.MoviePrecenter
import kotlinx.android.synthetic.main.activity_detail.*
import org.parceler.Parcels

class DetailActivity : AppCompatActivity(), Contactor.view {

    val precenter: Contactor.Precenter = MoviePrecenter()

    override fun fragmentData(arr: ArrayList<Movie>?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setup()
        onEvent()
    }

    fun setup() {
        val movie = intent.extras.get(MovieHolder.SHOWDETAIL_KEY)
        val movies: Movie = Parcels.unwrap(movie as Parcelable?)
        Glide.with(this).load(MainActivity.PICK_LINK + movies.poster).into(mv_poster)
        tv_ecname.setText(movies.title)
        tv_detail.setText(movies.overview)
        tv_releadedate.setText("วันที่เข้าฉาย : " + precenter.dateFormat(movies.release_date))
    }

    fun onEvent() {
        btn_back.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
