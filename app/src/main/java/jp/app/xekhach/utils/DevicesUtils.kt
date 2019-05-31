package jp.app.xekhach.utils

import android.content.Context
import android.net.ConnectivityManager

class DevicesUtils {
    fun hasNetworkConnection(context: Context?): Boolean {
        if (context == null) {
            return false
        }

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager ?: return false

        val wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (wifiNetwork != null && wifiNetwork.isConnected) {
            return true
        }

        val mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (mobileNetwork != null && mobileNetwork.isConnected) {
            return true
        }

        val activeNetwork = cm.activeNetworkInfo
        return if (activeNetwork != null && activeNetwork.isConnected) {
            true
        } else false
    }
}