package com.farukcuha.library.util

sealed class ViewState<out T> {
    data object Idle : ViewState<Nothing>()
    data object Loading : ViewState<Nothing>()
    data class Success<out T>(val data: T? = null) : ViewState<T>()
    data class Error(val error: Throwable? = null) : ViewState<Nothing>()
}