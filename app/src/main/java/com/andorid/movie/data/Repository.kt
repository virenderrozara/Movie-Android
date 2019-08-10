package com.android.movie.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.andorid.movie.api.WebService
import com.andorid.movie.network.BaseResponse
import com.andorid.movie.network.ResultResponse
import com.android.movie.base.BaseCallback

/**
 * class that implement Webservice Api
 */
class Repository(private val service: WebService) {

    private var mError: MutableLiveData<String> = MutableLiveData()
    val statusCode: MutableLiveData<Int> = MutableLiveData()
    fun getError(): LiveData<String> {
        mError = MutableLiveData()
        return mError
    }

    private var mDataError: MutableLiveData<BaseResponse<*>> = MutableLiveData()

    fun getDataError():LiveData<BaseResponse<*>>{
        mDataError = MutableLiveData()
        return mDataError
    }


    fun getMovieList(key: String): LiveData<BaseResponse<ResultResponse>> {
        val data = MutableLiveData<BaseResponse<ResultResponse>>()

        service.getMovieList(key).enqueue(object : BaseCallback<BaseResponse<ResultResponse>>() {
            override fun onSuccess(response: BaseResponse<ResultResponse>?) {
                data.value = response

            }

            override fun onFail(baseResponse: BaseResponse<*>?) {
//                mError.value = baseResponse?.message
//                statusCode.value = baseResponse?.statusCode
                mDataError.value= baseResponse

            }


        })
        return data

    }





}