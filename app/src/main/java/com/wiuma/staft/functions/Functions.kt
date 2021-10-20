package com.wiuma.staft.functions

import android.util.Log
import java.lang.reflect.Field

class Functions {
    companion object {
        public fun getResId(resName: String, c: Class<*>): Int {
            return try {
                val idField: Field = c.getDeclaredField(resName)
                idField.getInt(idField)
            } catch (e: Exception) {
                Log.println(Log.ASSERT, "exception", e.localizedMessage!!)
                e.printStackTrace()
                -1
            }
        }
    }
}