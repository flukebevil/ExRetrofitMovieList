package com.example.fluke.fuckermovie2.precenter

import android.util.Log
import com.example.fluke.fuckermovie2.Contractor
import com.example.fluke.fuckermovie2.MainActivity
import com.example.fluke.fuckermovie2.model.CallData
import com.example.fluke.fuckermovie2.model.Movie
import com.example.fluke.fuckermovie2.model.MovieList
import com.example.fluke.fuckermovie2.network.WTFManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(view: Contractor.View? = null) :
        Contractor.Presenter,
        Contractor.Model.OnFinishedListener {

    var data: ArrayList<Movie>? = null
    val model: Contractor.Model = CallData()
    val view: Contractor.View? = view

    override fun onSuccess(results: ArrayList<Movie>?) {
        view?.fragmentData(results)
    }

    override fun dateFormat(date: String?): String {
        val s = date?.split("-")?.toTypedArray()
        Log.e("dateformat", s?.get(0).toString())
        return "วันที่ ${s?.get(2)} เดือน " + getMonth(s?.get(1)) + " พ.ศ. ${s?.get(0)?.toInt()?.plus(543)}"
    }

    override fun testPresenter(key: String?) {
        model.callDataWtf(key, this)
    }

    fun getMonth(month: String?): String? {
        if (month == "01") {
            return "มกราคม"
        } else if (month == "02") {
            return "มกราคม"
        } else if (month == "03") {
            return "กุมพาพันธ์"
        } else if (month == "04") {
            return "มีนาคม"
        } else if (month == "05") {
            return "เมษายน"
        } else if (month == "06") {
            return "พฤษจิกายน"
        } else if (month == "07") {
            return "กรกฎาคม"
        } else if (month == "08") {
            return "สิงาตม"
        } else if (month == "09") {
            return "กันยายน"
        } else if (month == "10") {
            return "ตุลาคม"
        } else if (month == "11") {
            return "พฤศจิกายน"
        } else {
            return "ธันวาคม"
        }
    }
}