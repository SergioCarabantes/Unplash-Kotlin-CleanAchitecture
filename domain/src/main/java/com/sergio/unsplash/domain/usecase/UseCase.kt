package com.sergio.unsplash.domain.usecase

import io.reactivex.disposables.Disposable


abstract class UseCase<Request, Output> where Output : Any {

  abstract fun execute(request: Request, output: Output): Disposable
}
