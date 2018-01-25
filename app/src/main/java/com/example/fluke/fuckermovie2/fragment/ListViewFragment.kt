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

    private var detailAdapter: DetailAdapter? = null
    private var presenter: MoviePresenter? = null

    init {
        detailAdapter = DetailAdapter(listOf())
    }

    companion object {
        fun newInstance(key: String = "") = ListViewFragment().apply {
            arguments = Bundle().apply { putString(MainActivity.FUCKER_KEY, key) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MoviePresenter(this)
        presenter?.callDownData(arguments.getString(MainActivity.FUCKER_KEY))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewList?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = detailAdapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_view, container, false)

    override fun fragmentData(arr: ArrayList<Movie>?) {
        detailAdapter?.setItems(arr)
        detailAdapter?.notifyDataSetChanged()
    }
}