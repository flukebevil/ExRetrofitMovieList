package com.example.fluke.fuckermovie2.moviedetail

import com.example.fluke.fuckermovie2.moviedetail.model.InterActies
import com.example.fluke.fuckermovie2.moviedetail.model.YouVidData

class VidPresenter(val view: Contractor.Vid?) :
        Contractor.VidPresenter,
        DetailActor.OnVidCallBackListener {

    private val actData: DetailActor.ActData = InterActies()

    override fun onSuccess(results: ArrayList<YouVidData>?) {
        view?.vidView(results)
    }

    override fun vidPresenter(key: String?) {
        actData.callVidData(key, this)
    }

}