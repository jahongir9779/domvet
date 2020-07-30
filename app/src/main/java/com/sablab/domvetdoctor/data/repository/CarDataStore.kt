package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.domain.model.Car
import com.sablab.domvetdoctor.domain.model.CarColor
import com.sablab.domvetdoctor.domain.model.CarDetails
import com.sablab.domvetdoctor.domain.model.CarModel
import com.sablab.domvetdoctor.util.ResultWrapper


/**
 * Interface defining methods for the data operations related to Bufferroos.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface CarDataStore {
//    suspend fun getCars(token: String): ResultWrapper<List<CarDetails>>
    suspend fun getCarModels(token: String, lang: String): ResultWrapper<List<CarModel>>
    suspend fun getCarColors(token: String, lang: String): ResultWrapper<List<CarColor>>
//    suspend fun createCar(token: String, car: Car): ResultWrapper<String>
//    suspend fun updateCar(token: String, car: Car): ResultWrapper<String>
//    suspend fun deleteCar(token: String, id: Long): ResultWrapper<String>
//    suspend fun setDefaultCar(token: String, id: Long): ResultWrapper<String>
}