package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Car
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.models.User
import com.sablab.domvetdoctor.models.network.NUser

interface UserRepository {

    suspend fun loginUser(phoneNum: String): ResultWrapper<String>
//    suspend fun registerUser(user: User): ResultWrapper<String>
    suspend fun smsConfirm(userCredentials: UserCredentials): ResultWrapper<NUser>
    suspend fun updateUserCity(city: City): ResultWrapper<Boolean>


}