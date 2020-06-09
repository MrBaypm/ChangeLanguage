package com.bbx.language

import android.app.Application
import com.bbx.languagelib.MultiLanguageUtil

class WeApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        MultiLanguageUtil.init(this)
    }
}