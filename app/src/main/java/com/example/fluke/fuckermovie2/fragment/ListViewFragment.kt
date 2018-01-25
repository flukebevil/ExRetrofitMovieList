package com.example.fluke.fuckermovie2.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fluke.fuckermovie2.adapter.DetailAdapter
import com.example.fluke.fuckermovie2.Contractor
import com.example.fluke.fuckermovie2.MainActivity
import com.example.fluke.fuckermovie2.R
import com.example.fluke.fuckermovie2.model.Movie
import com.example.fluke.fuckermovie2.precenter.MoviePresenter
import kotlinx.android.synthetic.main.fragment_view.*

class ListViewFragment : Fragment(), Contractor.View {
    lateinit var linear: LinearLayoutManager
    var detailAdapter: DetailAdapter? = null
    lateinit var prescenter: MoviePresenter

    companion object {
        fun newInstance(key: String): ListViewFragment {
            val fragment: ListViewFragment = ListViewFragment()
            val bd: Bundle = Bundle()
            bd.putString(MainActivity.FUCKER_KEY, key)
            fragment.arguments = bd
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prescenter = MoviePresenter(this)
        prescenter.callDownData(arguments.getString(MainActivity.FUCKER_KEY))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linear = LinearLayoutManager(context)
        detailAdapter = DetailAdapter(arrayListOf(), context)
        view_List.layoutManager = linear
        view_List.adapter = detailAdapter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootViw = inflater!!.inflate(R.layout.fragment_view, container, false)
        return rootViw
    }

    override fun fragmentData(arr: ArrayList<Movie>?) {
//        Log.e("LOGGER", arr.toString())
        detailAdapter?.setItems(arr)
        detailAdapter?.notifyDataSetChanged()
    }
}