package com.bbx.language

import android.content.Context
import android.content.Intent
import android.os.Bundle

fun <T> Context.showActivity(clazz: Class<T>) {
    var intent = Intent(this, clazz)
    startActivity(intent)
}

fun <T> Context.showActivity(clazz: Class<T>, bundle: Bundle?) {
    var intent = Intent(this, clazz)
    intent.putExtra("data", bundle)
    startActivity(intent)
}
