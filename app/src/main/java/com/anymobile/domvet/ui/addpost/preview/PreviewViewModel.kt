package com.anymobile.domvet.ui.addpost.preview

import androidx.lifecycle.viewModelScope
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.usecases.CreatePassengerPost
import com.anymobile.domvet.ui.BaseViewModel
import com.anymobile.domvet.util.AppPreferences
import com.anymobile.domvet.util.SingleLiveEvent
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
