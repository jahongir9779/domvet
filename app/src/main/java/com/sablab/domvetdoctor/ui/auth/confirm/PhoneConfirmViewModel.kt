package com.sablab.domvetdoctor.ui.auth.confirm

import androidx.lifecycle.viewModelScope
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.domain.usecases.SmsConfirm
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.util.SingleLiveEvent
import com.sablab.domvetdoctor.util.numericOnly
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PhoneConfirmViewModel @Inject constructor(private val smsConfirm: SmsConfirm) :
    BaseViewModel() {
    val confirmResponse = SingleLiveEvent<ResultWrapper<NUser>>()

    fun confirm(phone: String, code: Int) {
        confirmResponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = smsConfirm.execute(UserCredentials(phone.numericOnly(), code, App.uuid))
            withContext(Main) {
                confirmResponse.value = response
            }
        }

    }

    // A placeholder username validation check
    private fun isCodeValid(code: String): Boolean {
        return code.length == 5
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
