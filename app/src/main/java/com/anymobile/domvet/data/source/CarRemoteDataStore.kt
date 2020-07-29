package com.anymobile.domvet.data.source

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.data.repository.CarDataStore
import com.anymobile.domvet.data.repository.CarRemote
import com.anymobile.domvet.data.repository.UserDataStore
import com.anymobile.domvet.domain.model.Car
import com.anymobile.domvet.domain.model.CarColor
import com.anymobile.domvet.domain.model.CarDetails
import com.anymobile.domvet.domain.model.CarModel
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class CarRemoteDataStore @Inject constructor(private val carRemote: CarRemote) :
    CarDataStore {
//    override suspend fun getCars(token: String): ResultWrapper<List<CarDetails>> {
//        return carRemote.getCars(token)
//    }

    override suspend fun getCarModels(token: String,
                                      lang: String): ResultWrapper<List<CarModel>> {
        return carRemote.getCarModels(token, lang)
    }

    override suspend fun getCarColors(token: String,
                                      lang: String): ResultWrapper<List<CarColor>> {
        return carRemote.getCarColors(token, lang)

    }

//    override suspend fun createCar(token: String, car: Car): ResultWrapper<String> {
//        return carRemote.createCar(token, car)
//    }
//
//    override suspend fun updateCar(token: String, car: Car): ResultWrapper<String> {
//        return carRemote.updateCar(token, car)
//    }
//
//    override suspend fun deleteCar(token: String, id: Long): ResultWrapper<String> {
//        return carRemote.deleteCar(token, id)
//    }
//
//    override suspend fun setDefaultCar(token: String, id: Long): ResultWrapper<String> {
//        return carRemote.setDefaultCar(token, id)
//    }

}