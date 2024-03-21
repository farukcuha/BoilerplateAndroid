package com.farukcuha.library.util

interface UseCase<P, T> {
    suspend operator fun invoke(params: P): T
}