package com.anymobile.domvet.ui.addpost.carandtext

import androidx.lifecycle.viewModelScope
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.CarDetails
import com.anymobile.domvet.ui.BaseViewModel
import com.anymobile.domvet.util.AppPreferences
import com.anymobile.domvet.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject


class CarAndTextViewModel @Inject constructor(/*private val getCars: GetCars*/) :
    BaseViewModel() {

//    val carsResponse = SingleLiveEvent<ResultWrapper<List<CarDetails>>>()
//
//
//    @ExperimentalSplittiesApi
//    fun getCars() {
//        carsResponse.value = ResultWrapper.InProgress
//
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = getCars.execute(AppPreferences.token)
//            withContext(Main) {
//               carsResponse.value = response
//            }
//        }
//    }


}
