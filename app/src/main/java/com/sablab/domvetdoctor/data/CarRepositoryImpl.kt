package com.sablab.domvetdoctor.data

import com.sablab.domvetdoctor.data.source.CarDataStoreFactory
import com.sablab.domvetdoctor.domain.model.Car
import com.sablab.domvetdoctor.domain.model.CarColor
import com.sablab.domvetdoctor.domain.model.CarDetails
import com.sablab.domvetdoctor.domain.model.CarModel
import com.sablab.domvetdoctor.domain.repository.CarRepository
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Provides an implementation of the [UserRepository] interface for communicating to and from
 * data sources
 */
class CarRepositoryImpl @Inject constructor(private val factory: CarDataStoreFactory) :
    CarRepository {

//    override suspend fun getCars(token: String): ResultWrapper<List<CarDetails>> {
//        val response = factory.retrieveDataStore(false)
//            .getCars(token)
//        return when (response) {
//            is ErrorWrapper.ResponseError -> response
//            is ErrorWrapper.SystemError -> response
//            is ResultWrapper.Success -> {
//                ResultWrapper.Success(response.value)
//            }
//            ResultWrapper.InProgress -> ResultWrapper.InProgress
//        }
//    }


    override suspend fun getCarModels(token: String, lang: String): ResultWrapper<List<CarModel>> {
        val response = factory.retrieveDataStore(false)
            .getCarModels(token, lang)
        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> {
                ResultWrapper.Success(response.value)
            }
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }

    override suspend fun getCarColors(token: String, lang: String): ResultWrapper<List<CarColor>> {
        val response = factory.retrieveDataStore(false).getCarColors(token, lang)
        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> {
                ResultWrapper.Success(response.value)
            }
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }

//    override suspend fun createCar(token: String, car: Car): ResultWrapper<String> {
//        val response = factory.retrieveDataStore(false).createCar(token, car)
//        return when (response) {
//            is ErrorWrapper.ResponseError -> response
//            is ErrorWrapper.SystemError -> response
//            is ResultWrapper.Success -> {
//                ResultWrapper.Success("SUCCESS")
//            }
//            ResultWrapper.InProgress -> ResultWrapper.InProgress
//        }
//    }
//
//    override suspend fun updateCar(token: String, car: Car): ResultWrapper<String> {
//        val response = factory.retrieveDataStore(false).updateCar(token, car)
//        return when (response) {
//            is ErrorWrapper.ResponseError -> response
//            is ErrorWrapper.SystemError -> response
//            is ResultWrapper.Success -> {
//                ResultWrapper.Success("SUCCESS")
//            }
//            ResultWrapper.InProgress -> ResultWrapper.InProgress
//        }
//    }
//
//    override suspend fun deleteCar(token: String, id: Long): ResultWrapper<String> {
//        val response = factory.retrieveDataStore(false)
//            .deleteCar(token, id)
//        return when (response) {
//            is ErrorWrapper.ResponseError -> response
//            is ErrorWrapper.SystemError -> response
//            is ResultWrapper.Success -> {
//                ResultWrapper.Success("SUCCESS")
//            }
//            ResultWrapper.InProgress -> ResultWrapper.InProgress
//        }
//    }
//
//    override suspend fun setDefaultCar(token: String, id: Long): ResultWrapper<String> {
//        val response = factory.retrieveDataStore(false)
//            .setDefaultCar(token, id)
//        return when (response) {
//            is ErrorWrapper.ResponseError -> response
//            is ErrorWrapper.SystemError -> response
//            is ResultWrapper.Success -> {
//                ResultWrapper.Success("SUCCESS")
//            }
//            ResultWrapper.InProgress -> ResultWrapper.InProgress
//        }
//    }


}