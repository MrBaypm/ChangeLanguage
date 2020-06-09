package com.bbx.language

import android.content.Intent
import android.os.Bundle
import com.bbx.language.adapter.LBaseAdapter
import com.bbx.languagelib.MultiLanguageUtil
import kotlinx.android.synthetic.main.activity_laguage_page.*

class ChangeLanguageActivity : BaseActivity() {

    private var baseAdapter: LBaseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laguage_page)

        baseAdapter = LBaseAdapter(
            arrayListOf(
                getString(R.string.setting_language_auto),
                getString(R.string.setting_language_english),
                getString(R.string.setting_simplified_chinese),
                getString(R.string.setting_traditional_chinese),
                getString(R.string.setting_language_japanese),
                getString(R.string.setting_language_korean)
            ), this, MultiLanguageUtil.getInstance().languageType
        )
        baseAdapter?.setChangeLanguageCallback {
            var selectedLanguage = it
            MultiLanguageUtil.getInstance().updateLanguage(selectedLanguage)
            showMain()
        }
        listView.adapter = baseAdapter
        baseAdapter?.notifyDataSetChanged()
    }

    fun showMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}