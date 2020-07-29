package com.anymobile.domvet.remote

import com.anymobile.domvet.data.repository.CarRemote
import com.anymobile.domvet.domain.model.Car
import com.anymobile.domvet.domain.model.CarColor
import com.anymobile.domvet.domain.model.CarDetails
import com.anymobile.domvet.domain.model.CarModel
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import javax.inject.Inject


/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class CarRemoteImpl @Inject constructor(private val apiService: ApiService) : CarRemote {

//    override suspend fun getCars(token: String): ResultWrapper<List<CarDetails>> {
//
//        return try {
//            val response = apiService.getCars(token)
//            if (response.code == 1) {
//                val newCars = ArrayList<CarDetails>()
//                response.data!!.forEach {
//                    newCars.add(it)
//                }
//                ResultWrapper.Success(newCars)
//            } else ErrorWrapper.ResponseError(response.code, response.message)
//        } catch (e: Exception) {
//            ErrorWrapper.SystemError(e)
//        }
//    }

    override suspend fun getCarModels(token: String,
                                      lang: String): ResultWrapper<List<CarModel>> {
        return try {
            val response = apiService.getCarModels(token, lang)
            if (response.code == 1) {
                val newCarModels = ArrayList<CarModel>()
                response.data!!.forEach {
                    newCarModels.add(it)
                }
                ResultWrapper.Success(newCarModels)
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

    override suspend fun getCarColors(token: String,
                                      lang: String): ResultWrapper<List<CarColor>> {
        return try {
            val response = apiService.getCarColors(token, lang)
            if (response.code == 1) {
                val newCarColors = ArrayList<CarColor>()
                response.data!!.forEach {
                    newCarColors.add(it)
                }
                ResultWrapper.Success(newCarColors)
            } else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

//    override suspend fun createCar(token: String, car: Car): ResultWrapper<String> {
//        return try {
//            val response = apiService.createCar(token, car)
//            if (response.code == 1) {
//                ResultWrapper.Success("SUCCESS")
//            } else ErrorWrapper.ResponseError(response.code, response.message)
//        } catch (e: Exception) {
//            ErrorWrapper.SystemError(e)
//        }
//    }
//
//    override suspend fun deleteCar(token: String, id: Long): ResultWrapper<String> {
//        return try {
//            val response =
//                apiService.deleteCar(token, id)
//            if (response.code == 1) {
//                ResultWrapper.Success("SUCCESS")
//            } else ErrorWrapper.ResponseError(response.code, response.message)
//        } catch (e: Exception) {
//            ErrorWrapper.SystemError(e)
//        }
//    }
//
//    override suspend fun updateCar(token: String, car: Car): ResultWrapper<String> {
//        return try {
//            val response =
//                apiService.updateCar(token, car.id!!, car)
//            if (response.code == 1) {
//                ResultWrapper.Success("SUCCESS")
//            } else ErrorWrapper.ResponseError(response.code, response.message)
//        } catch (e: Exception) {
//            ErrorWrapper.SystemError(e)
//        }
//    }
//
//
//    override suspend fun setDefaultCar(token: String, id: Long): ResultWrapper<String> {
//        return try {
//            val response = apiService.setDefaultCar(token, id)
//            if (response.code == 1) {
//                ResultWrapper.Success("SUCCESS")
//            } else ErrorWrapper.ResponseError(response.code, response.message)
//        } catch (e: Exception) {
//            ErrorWrapper.SystemError(e)
//        }
//    }


}