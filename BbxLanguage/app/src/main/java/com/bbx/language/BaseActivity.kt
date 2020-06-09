package com.bbx.language

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bbx.languagelib.MultiLanguageUtil

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(MultiLanguageUtil.attachBaseContext(newBase))
    }
}