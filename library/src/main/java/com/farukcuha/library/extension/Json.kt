package com.farukcuha.library.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> T.toJson(): String? {
    return Gson().toJson(this)
}

inline fun <reified T> String.toObject(): T {
    val typeToken = object : TypeToken<T>() {}.type
    return Gson().fromJson<T>(this, typeToken)
}