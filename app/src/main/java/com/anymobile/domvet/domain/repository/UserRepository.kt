package com.anymobile.domvet.domain.repository

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.Car
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.model.UserCredentials
import com.anymobile.domvet.domain.model.AuthBody

interface UserRepository {

    suspend fun loginUser(phoneNum: String): ResultWrapper<String>
    suspend fun registerUser(user: User): ResultWrapper<String>
    suspend fun smsConfirm(userCredentials: UserCredentials): ResultWrapper<AuthBody>

    fun updateUserDetails(user: User): ResultWrapper<Unit>
    fun addOrUpdateUserCar(car: Car): ResultWrapper< Unit>
    fun getUserCars(userId: String): ResultWrapper< List<Car>>
    fun deleteUserCar(carId: String): ResultWrapper< List<Car>>

}