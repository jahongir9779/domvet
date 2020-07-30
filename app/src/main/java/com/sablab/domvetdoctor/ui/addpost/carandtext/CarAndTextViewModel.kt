package com.sablab.domvetdoctor.ui.addpost.carandtext

import androidx.lifecycle.viewModelScope
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.CarDetails
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.AppPreferences
import com.sablab.domvetdoctor.util.SingleLiveEvent
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
