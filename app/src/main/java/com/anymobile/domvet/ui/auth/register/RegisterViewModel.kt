package com.anymobile.domvet.ui.auth.register

import androidx.lifecycle.viewModelScope
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.usecases.RegisterUser
import com.anymobile.domvet.ui.BaseViewModel
import com.anymobile.domvet.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val registerUser: RegisterUser) :
    BaseViewModel() {

    private val _registerForm = SingleLiveEvent<RegisterFormState>()
    val registerFormState: SingleLiveEvent<RegisterFormState> = _registerForm

    val response = SingleLiveEvent<ResultWrapper<String>>()

    fun register(user: User) {
            response.value = ResultWrapper.InProgress
            viewModelScope.launch(Dispatchers.IO)  {
                response.value = registerUser.execute(user)
            }
    }




}
