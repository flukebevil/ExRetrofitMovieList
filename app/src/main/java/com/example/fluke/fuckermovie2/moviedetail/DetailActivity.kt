package com.example.fluke.fuckermovie2.moviedetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.bumptech.glide.Glide
import com.example.fluke.fuckermovie2.moviedetail.Contractor.*
import com.example.fluke.fuckermovie2.MainActivity
import com.example.fluke.fuckermovie2.R
import com.example.fluke.fuckermovie2.moviedetail.adapter.YoutubeVidAdapter
import com.example.fluke.fuckermovie2.formatDateHunmanCanRead
import com.example.fluke.fuckermovie2.holder.MovieHolder
import com.example.fluke.fuckermovie2.model.Movie
import com.example.fluke.fuckermovie2.moviedetail.model.YouVidData
import kotlinx.android.synthetic.main.activity_detail.*
import org.parceler.Parcels

class DetailActivity : AppCompatActivity(), Vid {
    private lateinit var linear: LinearLayoutManager
    private var youtubeVidAdapter: YoutubeVidAdapter? = null
    private lateinit var vidPresenter: VidPresenter


    override fun vidView(arr: ArrayList<YouVidData>?) {
        youtubeVidAdapter?.setItems(arr)
        youtubeVidAdapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setup()
        btn_back.setOnClickListener { finish() }
    }

    private fun setup() {
        val movie = intent.extras.get(MovieHolder.SHOWDETAIL_KEY)
        val movies: Movie = Parcels.unwrap(movie as Parcelable?)

        vidPresenter = VidPresenter(this)
        vidPresenter.vidPresenter(movies.title)
        linear = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        youtubeVidAdapter = YoutubeVidAdapter(arrayListOf(), this)
        fucktube_recy.layoutManager = linear
        fucktube_recy.adapter = youtubeVidAdapter

        Glide.with(this).load(MainActivity.PICK_LINK + movies.poster).into(mv_poster)
        tv_ecname.text = movies.title
        tv_detail.text = movies.overview
        tv_releadedate.text = movies.release_date?.formatDateHunmanCanRead()

    }
}
