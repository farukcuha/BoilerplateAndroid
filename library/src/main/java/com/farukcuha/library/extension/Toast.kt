package com.farukcuha.library.extension

import android.content.Context
import android.widget.Toast

fun Context.showShortToast(message: String? = null) {
    Toast.makeText(this, message ?: "Hello World!", Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(message: String? = null) {
    Toast.makeText(this, message ?: "Hello World!", Toast.LENGTH_LONG).show()
}

