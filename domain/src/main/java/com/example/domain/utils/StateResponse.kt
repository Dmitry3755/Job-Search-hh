package com.example.domain.utils

sealed class StateResponse<T> {
    class Success<T>(val result: T) : StateResponse<T>()
    class Error<T>(val error : String) : StateResponse<T>()
}