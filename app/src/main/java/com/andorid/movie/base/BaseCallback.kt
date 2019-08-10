
package com.android.movie.base



import com.andorid.movie.network.BaseResponse
import com.android.movie.data.LogUtils
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Callback wrapper written to handle some generic response sent by server like 401, 4.2, etc.
 */
abstract class BaseCallback<T : BaseResponse<*>> : Callback<T> {

    private val tAg= LogUtils.makeLogTag(BaseCallback::class.java.simpleName)
    /**
     * Invoked when Successful response sent from server.
     *
     * @param response Response from server
     */
    abstract fun onSuccess(response: T?)

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    abstract fun onFail(baseResponse: BaseResponse<*>?)

    override fun onResponse(call: Call<T>, response: Response<T>) {
        //Generic error response code are handled at base level
        if (response.isSuccessful) {
            onSuccess(response.body())

        } else {
            val body = response.errorBody()
            val baseResponse = BaseResponse<T>()
//            LogUtils.lOGE(tAg, "" + baseResponse.statusCode)


            try {
                val errorBody = String(if (body != null) body.bytes() else ByteArray(0))
                val jsonError = JSONObject(errorBody)
                LogUtils.lOGE(tAg, "error body::=$jsonError")
                LogUtils.lOGE(tAg, "error body::=" +response.code())

//                if (jsonError.has(MESSAGE)) {
//                    baseResponse.message = jsonError.getString(MESSAGE)
//                    baseResponse.statusCode = response.code()
//
//                }

                //TODO: If status code or Response Code
//                if (jsonError.has(STATUS_CODE)) {
//                    val statusCode = jsonError.getInt(STATUS_CODE)
//                    baseResponse.statusCode = statusCode
//                }
//
//                if (baseResponse.statusCode == CODE_401) {
//                    baseResponse.message = baseResponse.message
//
//
//                } else if (baseResponse.statusCode == CODE_500) {
//                    onFail(baseResponse)
//                } else if (baseResponse.statusCode == CODE_400) {
//                    if (baseResponse.message != null && baseResponse.message!!.isNotEmpty()) {
//                        baseResponse.message = baseResponse.message
//                    } else {
//                        baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_no_network_connection)
//                    }
//                }

                onFail(baseResponse)
            } catch (e: ConnectException) {
                LogUtils.printStackTrace(e)

//                baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_connection_failed)
                onFail(baseResponse)
            } catch (e: JSONException) {
                LogUtils.printStackTrace(e)
//                baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_data_parsing)
                onFail(baseResponse)
            } catch (e: IOException) {
                LogUtils.printStackTrace(e)
//                baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_data_parsing)
                onFail(baseResponse)
            }

        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        LogUtils.lOGE(TAG, "api onFailure " + t.message + " " + t.localizedMessage)
        val baseResponse = BaseResponse<T>()
        onFail(baseResponse)
//        if (t is UnknownHostException) {
//            LogUtils.lOGD(CommonConstants.TAG,"")
//            baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_no_network_connection)
////                        act.showToast(act.getApplicationContext().getString(R.string.error_no_network_connection));
//            onFail(baseResponse)
//        } else if (t is SocketTimeoutException) {
//            baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_network_timed_out)
//            onFail(baseResponse)
//        } else if (t is ConnectException) {
//            baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_connection_failed)
//            onFail(baseResponse)
//        } else if (t is SocketException || t is IOException && t.getLocalizedMessage() == "Canceled") {
//            onFail(baseResponse)
//        } else {
//            baseResponse.message = CommonCentsApplication.getAppContext().getString(R.string.alert_something_went_wrong)
//            onFail(baseResponse)
//        }
    }

    companion object {

        val TAG = LogUtils.makeLogTag(BaseCallback::class.java.simpleName)
    }
}
