package com.example.fluke.fuckermovie2

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun String.formatDateHunmanCanRead():String {
    val df = SimpleDateFormat("yyyy-MM-dd")
    val date = df.parse(this)
    val resultDate = SimpleDateFormat("dd,EEEE,MMMM,yyyy").format(date)
    val splitDate = resultDate.split(",")
    return "วันที่ ${splitDate.get(0)} เดือน ${splitDate.get(2)} ปี ${splitDate.get(3)}"
}