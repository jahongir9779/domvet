package com.anymobile.domvet.ui.main.mytrips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anymobile.domvet.ui.BaseViewModel
import javax.inject.Inject

class MyTripsViewModel @Inject constructor() : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}