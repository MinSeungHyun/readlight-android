package com.readlab.readlight.domain.usecase

import com.readlab.readlight.domain.common.SingleRxTransformer
import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.repositories.SignInQuery
import com.readlab.readlight.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class UserUseCase(
    private val transformer: SingleRxTransformer<Response>,
    private val repository: UserRepository
) {
    fun postSignIn(query: SignInQuery = SignInQuery()): Single<Response> {
        return repository.postSignIn(query).compose(transformer)
    }
}