package com.example.fluke.fuckermovie2.precenter

import com.example.fluke.fuckermovie2.Contractor
import com.example.fluke.fuckermovie2.InterActor
import com.example.fluke.fuckermovie2.model.InterActies
import com.example.fluke.fuckermovie2.model.Movie

class MoviePresenter(view: Contractor.View? = null) :
        Contractor.Presenter,
        InterActor.OnFinishedListener {

    var data: ArrayList<Movie>? = null
    private val actData: InterActor.ActData = InterActies()
    val view: Contractor.View? = view

    override fun onSuccess(results: ArrayList<Movie>?) {
        view?.fragmentData(results)
    }

    override fun callDownData(key: String?) {
        if (key?.length == 0){
            actData.callPopular(this)
        }else
        {
            actData.callDataWtf(key, this)
        }
    }


}