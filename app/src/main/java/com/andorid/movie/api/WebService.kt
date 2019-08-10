package com.andorid.movie.api
import com.andorid.movie.BuildConfig
import com.andorid.movie.network.BaseResponse
import com.andorid.movie.network.ResultResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * All Api are written here
 */
interface WebService {

    @GET("movie/now_playing")
    fun getMovieList(@Query("api_key")  apiKey:String): Call<BaseResponse<ResultResponse>>



    companion object {
//        private const val baseUrl = BuildConfig.Base_Url

        fun create(): WebService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()

            client.addInterceptor {
                val original = it.request()
//                val authToken = PreferenceUtil.getAuthToken()


//                if (authToken != null) {
//                    val builder = original.newBuilder()
//                            .header(CommonConstants.AUTH_TOKEN, authToken)
//                            .method(original.method(), original.body())
//
////                    if (PreferenceUtil.getYodleUserSession() != null && PreferenceUtil.getYodleUserSession()!!.cobSession != null) {
////                        builder.header(CommonConstants.AUTH_COB_SESSION, PreferenceUtil.getYodleUserSession()!!.cobSession)
////                    }
////                    if (PreferenceUtil.getYodleUserSession() != null && PreferenceUtil.getYodleUserSession()!!.userSession != null) {
////                        builder.header(CommonConstants.AUTH_USER_SESSION, PreferenceUtil.getYodleUserSession()!!.userSession)
////                    }
//
//
//                    val request = builder.build()
//                    return@addInterceptor it.proceed(request)
//                } else {
//
//                    return@addInterceptor it.proceed(original)
//                }
                return@addInterceptor it.proceed(original)

            }

            client.addInterceptor(logger)

            return Retrofit.Builder()
                    .baseUrl(BuildConfig.Base_Url)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WebService::class.java)
        }


    }
}