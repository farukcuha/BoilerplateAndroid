package com.farukcuha.library.util

interface BaseUseCase<P, T> {
    suspend operator fun invoke(params: P): Result<T>
}