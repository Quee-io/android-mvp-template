package io.quee.mvp.template

import android.content.Context
import io.quee.mvp.QueeApplication
import io.quee.mvp.utils.SharedPreferencesHelper

/**
 * Created by Ibrahim Al-Tamimi on 3/4/20.
 * Licensed for Quee.io
 */

class TemplateApplication : QueeApplication() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferencesHelper.init(getSharedPreferences("appPref", Context.MODE_PRIVATE))
    }

    override fun certificateRaw(): Int {
        return 0
    }

    override fun serverUrl(): String = "https://my-json-server.typicode.com"
}