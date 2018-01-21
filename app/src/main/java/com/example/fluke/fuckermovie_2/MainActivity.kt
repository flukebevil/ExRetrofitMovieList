package com.example.fluke.fuckermovie_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fluke.fuckermovie_2.fragment.ListViewFragment
import com.example.fluke.fuckermovie_2.precenter.MoviePrecenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var search : String
    var viewFragment: ListViewFragment = ListViewFragment()
    var precenter: Contactor.Precenter = MoviePrecenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance("a")).commit()
        btn_search.setOnClickListener {
             search = et_search.text.toString()
            val bd  : Bundle = Bundle()
            bd.putString("S_KEY",search)
            viewFragment.arguments = bd
            supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance(search)).commit()
        }
    }
}

