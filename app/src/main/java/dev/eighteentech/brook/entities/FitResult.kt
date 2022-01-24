package dev.eighteentech.brook.entities

import java.lang.Exception

sealed class FitResult<out T> {
    object NotLaunched : FitResult<Nothing>()
    object Loading : FitResult<Nothing>()
    data class Success<T>(val data: T) : FitResult<T>()
    data class Fail(val exception: Exception) : FitResult<Nothing>()
}
