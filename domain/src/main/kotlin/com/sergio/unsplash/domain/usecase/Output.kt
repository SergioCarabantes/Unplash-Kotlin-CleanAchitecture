package com.sergio.unsplash.domain.usecase

interface Output {

    fun onUnknownError(throwable: Throwable)
}
