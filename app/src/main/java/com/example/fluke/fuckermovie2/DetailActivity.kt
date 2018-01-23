package com.example.fluke.fuckermovie2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie2.adapter.YoutubeVidAdapter
import com.example.fluke.fuckermovie2.holder.MovieHolder
import com.example.fluke.fuckermovie2.model.Movie
import com.example.fluke.fuckermovie2.model.YouVidData
import com.example.fluke.fuckermovie2.precenter.MoviePresenter
import com.example.fluke.fuckermovie2.precenter.VidPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import org.parceler.Parcels

class DetailActivity : AppCompatActivity(), Contractor.View.Vid {
    lateinit var linear: LinearLayoutManager
    var youtubeVidAdapter: YoutubeVidAdapter? = null
    val presenter: Contractor.Presenter = MoviePresenter()
    lateinit var vidPresenter: VidPresenter


    override fun vidView(arr: ArrayList<YouVidData>?) {
        youtubeVidAdapter?.setItems(arr)
        youtubeVidAdapter?.notifyDataSetChanged()
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

        vidPresenter = VidPresenter(this)
        vidPresenter.vidPresenter(movies.title)
        linear = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        youtubeVidAdapter = YoutubeVidAdapter(arrayListOf(), this)
        fucktube_recy.layoutManager = linear
        fucktube_recy.adapter = youtubeVidAdapter

        Glide.with(this).load(MainActivity.PICK_LINK + movies.poster).into(mv_poster)
        tv_ecname.setText(movies.title)
        tv_detail.setText(movies.overview)
        tv_releadedate.setText("วันที่เข้าฉาย : " + presenter.dateFormat(movies.release_date))
    }

    fun onEvent() {
        btn_back.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
