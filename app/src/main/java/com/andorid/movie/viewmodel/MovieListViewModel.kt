package com.appster.commoncents.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import com.andorid.movie.base.Injection
import com.andorid.movie.network.BaseResponse
import com.andorid.movie.network.ResultResponse
import com.android.movie.base.BaseActivity
import com.android.movie.data.Repository

class MovieListViewModel(private val repo: Repository) : ViewModel() {
    /**
     * set all error
     */
    fun getError(): LiveData<String> {

        return repo.getError()
    }
    fun getDataError(): LiveData<BaseResponse<*>> {

        return repo.getDataError()
    }
    fun getMovieList(key : String): LiveData<BaseResponse<ResultResponse>> {
        return repo.getMovieList(key)

    }


    companion object {
        fun getInstance(activity: BaseActivity): MovieListViewModel {

            return ViewModelProviders.of(activity).get(MovieListViewModel::class.java)
        }
        fun create(activity: BaseActivity): MovieListViewModel {

            return ViewModelProviders.of(activity, Injection.provideViewModelFactory(activity)).get(MovieListViewModel::class.java)
        }
    }

}