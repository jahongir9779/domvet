package com.sablab.domvetdoctor.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns

import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor() : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}