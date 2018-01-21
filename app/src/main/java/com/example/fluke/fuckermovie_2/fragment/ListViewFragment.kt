package com.example.fluke.fuckermovie_2.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fluke.fuckermovie_2.Adapter.DetailAdapter
import com.example.fluke.fuckermovie_2.Contactor
import com.example.fluke.fuckermovie_2.R
import com.example.fluke.fuckermovie_2.model.MovieList
import com.example.fluke.fuckermovie_2.network.WTFManager
import com.example.fluke.fuckermovie_2.precenter.MoviePrecenter
import kotlinx.android.synthetic.main.fragment_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewFragment() : Fragment(), Contactor.view {
    lateinit var linear: LinearLayoutManager
    var detailAdapter: DetailAdapter? = null
    lateinit var prescenter : Contactor.Precenter

    companion object {
        fun newInstance( key : String):ListViewFragment{
            val fragment : ListViewFragment =  ListViewFragment()
            val bd : Bundle= Bundle()
            bd.putString("S_KEY" , key)
            fragment.arguments  = bd
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prescenter = MoviePrecenter()

        WTFManager.Factory.create().search(arguments.getString("S_KEY")).enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            }
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                if (response != null) {
                    Log.e("df" , response.body()!!.results.toString())
                    linear = LinearLayoutManager(context)
                    detailAdapter = DetailAdapter(response.body()!!.results, context)
                    view_List.layoutManager = linear
                    view_List.adapter = detailAdapter
                    view_List.adapter.notifyDataSetChanged()
                }
            }
        })
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootViw = inflater!!.inflate(R.layout.fragment_view, container, false)
        return rootViw
    }
}