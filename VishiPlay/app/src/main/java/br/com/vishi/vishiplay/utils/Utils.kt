package br.com.vishi.vishiplay.utils

import android.content.Context
import android.net.ConnectivityManager
import android.text.TextUtils



public fun isOnLine(context: Context): Boolean {
        val connectiviyManeger = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectiviyManeger.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
}
public fun verificaCampovazio(valor: String): Boolean {
            return TextUtils.isEmpty(valor) || valor.trim { it <= ' ' }.isEmpty()
}


