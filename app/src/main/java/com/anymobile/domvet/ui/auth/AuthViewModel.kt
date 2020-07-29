package com.anymobile.domvet.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns

import com.anymobile.domvet.R
import com.anymobile.domvet.ui.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor() : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}