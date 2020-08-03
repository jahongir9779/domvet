package com.sablab.domvetdoctor.ui.registration.selectcity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.ui.BaseViewModel
import javax.inject.Inject


class SelectCityFragViewModel @Inject constructor() : BaseViewModel() {

    private val _selected_city: MutableLiveData<City?> = MutableLiveData()
    val selected_city: LiveData<City?> get() = _selected_city

    fun citySelected(city: City) {
        _selected_city.value = city

    }

}
