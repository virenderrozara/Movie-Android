package com.andorid.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.andorid.movie.base.Injection
import com.android.movie.data.LogUtils
import com.appster.commoncents.viewmodel.MovieListViewModel

class SplashActivity : AppCompatActivity() {
    private var mViewModel: MovieListViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mViewModel= ViewModelProviders.of(this, Injection.provideViewModelFactory(this)).get(MovieListViewModel::class.java)
        getMovieList()
    }
    private fun getMovieList() {
//        showProgress()
        mViewModel?.getMovieList(BuildConfig.Api_KEY)?.observe(this, Observer {
//            hideProgress()
            if (it != null) {
//                PreferenceUtil.setUserInfo(it.result!!.user!!)
//                CustomAlertDialog.showDialog(activity!!, it.message!!, this)
                LogUtils.lOGD("tag","data=="+it.results?.get(0).title)
                LogUtils.lOGD("tag","data=="+it.results)
            }

        })
    }

}
