package com.android.movie.data

import android.util.Log


object LogUtils {
    private const val LOG_PREFIX = "MovieAndroid:"
    private const val LOG_PREFIX_LENGTH = LOG_PREFIX.length
    private const val MAX_LOG_TAG_LENGTH = 23
    @JvmStatic
    fun lOGD(tag: String, message: String) {
        Log.d(tag, message)
    }

    @JvmStatic
    fun lOGE(tag: String, message: String) {
        Log.e(tag, message)
    }

    @JvmStatic
    fun printStackTrace(e: Throwable) {
        e.printStackTrace()
    }

    fun makeLogTag(str: String): String {
        return if (str.length > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1)
        } else LOG_PREFIX + str

    }
}
