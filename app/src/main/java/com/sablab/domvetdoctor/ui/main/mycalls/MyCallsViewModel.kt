package com.sablab.domvetdoctor.ui.main.mycalls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sablab.domvetdoctor.ui.BaseViewModel
import javax.inject.Inject

class MyCallsViewModel @Inject constructor() : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}