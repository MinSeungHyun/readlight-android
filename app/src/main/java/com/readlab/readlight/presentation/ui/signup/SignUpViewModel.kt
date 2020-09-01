package com.readlab.readlight.presentation.ui.signup

import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel

class SignUpViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val name = MutableLiveData<String>("")
    val phone = MutableLiveData<String>("")

    val userQuery = SignUpQuery()

    fun signUp() {
        val disposable = userUseCase
            .postSignUp(userQuery)
            .subscribe({ response ->
                Logger.d("On Next Called: $response")
                if (response != null) {
                    Logger.d("Sign In Success")
                } else {
                    Logger.d("Response is null!")
                }
            }, {
                Logger.d("On Error!: $it")
            })

        addDisposable(disposable)
    }
}
