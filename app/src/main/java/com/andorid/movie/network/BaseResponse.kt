package com.andorid.movie.network

class BaseResponse<T> {
    //    var message: String? = null
//    var statusCode: Int = 0
    lateinit var results: ArrayList<T>
    var page: Int = 0
    var total_pages: Int = 0
    var total_results: Int = 0
}
