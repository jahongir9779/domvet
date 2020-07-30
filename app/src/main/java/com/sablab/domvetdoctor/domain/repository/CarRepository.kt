package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.*


interface CarRepository {

//    suspend fun getCars(token: String): ResultWrapper<List<CarDetails>>
    suspend fun getCarModels(token: String, lang:String): ResultWrapper<List<CarModel>>
    suspend fun getCarColors(token: String, lang:String): ResultWrapper<List<CarColor>>
//    suspend fun createCar(token: String, car: Car): ResultWrapper<String>
//    suspend fun updateCar(token: String, car: Car): ResultWrapper<String>
//    suspend fun deleteCar(token: String, id: Long): ResultWrapper<String>
//    suspend fun setDefaultCar(token: String, id:Long): ResultWrapper<String>


}