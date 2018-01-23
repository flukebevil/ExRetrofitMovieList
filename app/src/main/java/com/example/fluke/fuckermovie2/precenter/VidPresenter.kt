package com.example.fluke.fuckermovie2.precenter

import com.example.fluke.fuckermovie2.Contractor
import com.example.fluke.fuckermovie2.model.CallData
import com.example.fluke.fuckermovie2.model.YouVidData

class VidPresenter(view: Contractor.View.Vid? = null) :
        Contractor.Presenter.VidPresenter,
        Contractor.Model.OnVidCallBackListener {

    val model: Contractor.Model = CallData()
    val view: Contractor.View.Vid? = view

    override fun onSuccess(results: ArrayList<YouVidData>?) {
        view?.vidView(results)
    }

    override fun vidPresenter(key: String?) {
        model.callVidData(key, this)
    }

}