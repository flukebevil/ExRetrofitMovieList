package com.example.fluke.fuckermovie_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.fluke.fuckermovie_2.fragment.ListViewFragment
import com.example.fluke.fuckermovie_2.model.Movie
import com.example.fluke.fuckermovie_2.model.MovieList
import com.example.fluke.fuckermovie_2.network.WTFManager
import org.parceler.Parcels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class MainActivity : AppCompatActivity()  {
    var viewFragment: ListViewFragment = ListViewFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WTFManager.Factory.create().getList().enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            }
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                if (response != null) {
                    val bundle : Bundle = Bundle()
                    val arr : ArrayList<Movie>? = response.body()!!.results
                    val parcelable : Parcelable = Parcels.wrap(arr)
                    bundle.putSerializable("KEYDATA" , arr as Serializable)
                    viewFragment.arguments = bundle
                    supportFragmentManager.beginTransaction().replace(R.id.view, viewFragment).commit()
                }
            }
        })

    }
}
