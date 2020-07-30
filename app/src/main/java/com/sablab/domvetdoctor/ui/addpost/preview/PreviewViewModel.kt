package com.sablab.domvetdoctor.ui.addpost.preview

import androidx.lifecycle.viewModelScope
import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.domain.usecases.CreatePassengerPost
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.AppPreferences
import com.sablab.domvetdoctor.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject


class PreviewViewModel @Inject constructor(private val createPassengerPost: CreatePassengerPost) :
    BaseViewModel() {

    val createResponse = SingleLiveEvent<ResultWrapper<String>>()


    @ExperimentalSplittiesApi
    fun createPassengerPost(driverPost: PassengerPost) {
        createResponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = createPassengerPost.execute(
                hashMapOf(Pair(Constants.TXT_TOKEN, AppPreferences.token),
                          Pair(Constants.TXT_PASSENGER_POST, driverPost)))

            withContext(Main) {
                createResponse.value = response
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
    }


}
