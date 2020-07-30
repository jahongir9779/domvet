package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Car
import com.sablab.domvetdoctor.domain.model.CarColor
import com.sablab.domvetdoctor.domain.model.CarDetails
import com.sablab.domvetdoctor.domain.model.CarModel


/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface CarRemote {

//    suspend fun getCars(token: String): ResultWrapper<List<CarDetails>>
    suspend fun getCarModels(token: String, lang:String): ResultWrapper<List<CarModel>>
    suspend fun getCarColors(token: String, lang:String): ResultWrapper<List<CarColor>>
//    suspend fun createCar(token: String, car: Car): ResultWrapper<String>
//    suspend fun deleteCar(token: String, id: Long): ResultWrapper<String>
//    suspend fun updateCar(token: String, car: Car): ResultWrapper<String>
//    suspend fun setDefaultCar(token: String, id: Long): ResultWrapper<String>
}