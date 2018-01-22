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
        val FUCKER_KEY = "S_KEY"
        val PICK_LINK = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance("a")).commit()
        btn_search.setOnClickListener {
            search = et_search.text.toString()
            val bd: Bundle = Bundle()
            if (search.matches("".toRegex())) {
                Toast.makeText(this, "กรอกดิไอ่เห้", Toast.LENGTH_SHORT).show()
            } else {
                bd.putString(FUCKER_KEY, search)
                viewFragment.arguments = bd
                supportFragmentManager.beginTransaction().replace(R.id.view, ListViewFragment.newInstance(search)).commit()
            }
        }
    }
}


