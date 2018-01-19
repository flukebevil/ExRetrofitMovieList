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
import com.example.fluke.fuckermovie_2.model.Movie
import kotlinx.android.synthetic.main.fragment_view.*

class ListViewFragment : Fragment(), Contactor.view {
    var arr: ArrayList<Movie>? = ArrayList()
    lateinit var linear: LinearLayoutManager
    var detailAdapter: DetailAdapter? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arr : ArrayList<Movie>? = arguments.getSerializable("KEYDATA") as ArrayList<Movie>?
        linear = LinearLayoutManager(context)
        detailAdapter = DetailAdapter(arr, context)
        view_List.layoutManager = linear
        view_List.adapter = detailAdapter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootViw = inflater!!.inflate(R.layout.fragment_view, container, false)
        return rootViw
    }

    override fun fragmentData(arr: ArrayList<Movie>?) {
        this.arr = arr
        Log.e("data", this.arr.toString())
    }
}