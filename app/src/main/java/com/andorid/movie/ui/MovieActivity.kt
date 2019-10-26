package com.andorid.movie.ui

import android.app.Activity
import android.os.Bundle

class MovieActivity: Activity() {
     var sum:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    inline fun add(a:Int,b:Int){
        sum=a+b;
    }
}