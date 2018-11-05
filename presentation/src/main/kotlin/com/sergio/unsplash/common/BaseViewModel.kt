package com.sergio.unsplash.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergio.unsplash.common.exception.Failure


abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}
