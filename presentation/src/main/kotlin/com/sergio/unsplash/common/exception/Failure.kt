package com.sergio.unsplash.common.exception

sealed class Failure {
    object NetworkConnection: Failure()
    object ServerError : Failure()
    object UnknowError : Failure()
    abstract class FeatureFailure: Failure()
}
