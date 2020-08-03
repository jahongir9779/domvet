package com.sablab.domvetdoctor.ui.selectcity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sablab.domvetdoctor.commons.Event
import com.sablab.domvetdoctor.domain.usecases.GetCities
import com.sablab.domvetdoctor.domain.usecases.UpdateUser
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.util.exhaustive
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectCityActViewModel @Inject constructor(val getCities: GetCities,
                                                 val updateUser: UpdateUser) :
    BaseViewModel() {


    private val _errorMessage: MutableLiveData<Event<String>> = MutableLiveData()
    val errorMessage: LiveData<Event<String>> get() = _errorMessage

    private val _progress: MutableLiveData<Event<Boolean>> = MutableLiveData()
    val progress: LiveData<Event<Boolean>> get() = _progress

    private val _cities: MutableLiveData<List<City>> = MutableLiveData()
    val cities: LiveData<List<City>> get() = _cities

    private val _selected_city: MutableLiveData<City?> = MutableLiveData()
    val selected_city: LiveData<City?> get() = _selected_city

    fun downloadCities() {
        _progress.value = Event(true)
        viewModelScope.launch {
            when (val result = getCities.execute()) {
                is ErrorWrapper.ResponseError -> {
                    _progress.value = Event(false)
//                    println(ErrorTranslator.translate(result.exception))
//                    _errorMessage.value = Event(ErrorTranslator.translate(result.exception))
                }
                is ErrorWrapper.SystemError -> {
                    _progress.value = Event(false)
                }
                is ResultWrapper.Success -> {
                    _progress.value = Event(false)
                    _cities.value = result.value
                }
                ResultWrapper.InProgress -> {
                    _progress.value = Event(true)
                }
            }.exhaustive
        }

//        is Result.Success -> {
//            _progress.value = Event(false)
//            _cities.value = result.data
//        }
//        is Result.Error -> {
//            _progress.value = Event(false)
//            println(ErrorTranslator.translate(result.exception))
//            _errorMessage.value = Event(
//                ErrorTranslator.translate(
//                    result.exception
//                )
//            )
//        }

    }

    fun setSelectedCity(it: City) {
        _selected_city.value = it
    }

//    fun saveCityToUser(doneAction: () -> Unit, failAction: () -> Unit) {
//        val city = selected_city.value
//        if (city == null) {
//            _errorMessage.value =
//                Event("Место выберите свой город")
//            failAction.invoke()
//        } else {
//            _progress.value = Event(true)
//            viewModelScope.launch {
//                when (val result = userRepository.updateUserCity(city)) {
//                    is Result.Success -> {
//                        _progress.value = Event(false)
//                        doneAction.invoke()
//                    }
//                    is Result.Error -> {
//                        _progress.value = Event(false)
//                        println(ErrorTranslator.translate(result.exception))
//                        _errorMessage.value = Event(
//                            ErrorTranslator.translate(
//                                result.exception
//                            )
//                        )
//                        failAction.invoke()
//                    }
//                }
//            }
//        }
//    }


}