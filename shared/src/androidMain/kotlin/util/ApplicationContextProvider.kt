package util

import android.content.Context

object ApplicationContextProvider {

    lateinit var applicationContext: Context
        private set

    fun init(context: Context) {
        this.applicationContext = context
    }
}