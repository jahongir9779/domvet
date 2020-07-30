package com.sablab.domvetdoctor.ui.auth.phone

import androidx.lifecycle.viewModelScope
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.util.numericOnly
import com.sablab.domvetdoctor.domain.usecases.LogUserIn
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PhoneViewModel @Inject constructor(private val logUserIn: LogUserIn) : BaseViewModel() {

    val loginResponse = SingleLiveEvent<ResultWrapper<String>>()
//
//    private val _loginResult = MutableLiveData<LoginResult>()
//    val loginResult: LiveData<LoginResult> = _loginResult

    var phoneNum = ""
    fun login(phoneNum: String) {
        this.phoneNum = phoneNum
        loginResponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = logUserIn.execute(phoneNum.numericOnly())
            withContext(Main) {
                loginResponse.value = response
            }
        }
    }

//    // A placeholder username validation check
//    private fun isPhoneValid(phoneNum: String): Boolean {
//        return if (phoneNum.numericOnly().length == 12) true else {
//            _loginForm.value = LoginFormState(phoneError = R.string.incorrect_phone_number_format)
//            false
//        }
//    }

//    // A placeholder password validation check
//    private fun isPasswordValid(password: String): Boolean {
//        return password.length > 5
//    }
}
