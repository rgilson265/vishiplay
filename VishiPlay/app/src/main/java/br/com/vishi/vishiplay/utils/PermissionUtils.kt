package br.com.vishi.vishiplay.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionUtils {
    companion object{
        fun validate(activity: Activity, vararg permissions: String):Boolean{
            val list = ArrayList<String>()
            for (permission in permissions){
                val ok = ContextCompat.checkSelfPermission(activity,permission) == PackageManager.PERMISSION_GRANTED
                if (!ok){
                    list.add(permission)
                }
            }
            if (list.isEmpty()){
                return true
            }
            val newPermissions = arrayOfNulls<String>(list.size)
            list.toArray(newPermissions)
            ActivityCompat.requestPermissions(activity,newPermissions,1)
            return false
        }
    }
}