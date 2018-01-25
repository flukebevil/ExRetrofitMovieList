package com.example.fluke.fuckermovie2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fluke.fuckermovie2.fragment.ListViewFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var search: String
    var viewFragment: ListViewFragment = ListViewFragment()

    companion object {
        const val FUCKER_KEY = "S_KEY"
        const val PICK_LINK = "https://image.tmdb.org/t/p/w500"
        const val POSTER_VID = "https://i.ytimg.com/vi/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance()).commit()
        btn_pop.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance()).commit()
        }
        btn_search.setOnClickListener {
            search = et_search.text.toString()
            if (search.matches("".toRegex())) {
                Toast.makeText(this, "กรอกดิไอ่เห้", Toast.LENGTH_SHORT).show()
            } else {
                viewFragment.arguments = Bundle().apply { putString(FUCKER_KEY, search) }
                supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance(search)).commit()
            }
        }
    }
}


