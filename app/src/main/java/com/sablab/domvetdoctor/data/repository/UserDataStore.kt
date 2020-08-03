package com.sablab.domvetdoctor.data.repository

import android.graphics.Bitmap
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.models.User
import com.sablab.domvetdoctor.models.network.NCity
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.util.ResultWrapper


/**
 * Interface defining methods for the data operations related to Bufferroos.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface UserDataStore {

    suspend fun userLogin(phoneNum: String): ResultWrapper<String>
    suspend fun confirmSms(userCredentials: UserCredentials): ResultWrapper<NUser>
    suspend fun saveUserCity(city: City): ResultWrapper<NUser>
    suspend fun saveUser(user: User, image: Bitmap): ResultWrapper<NUser>
}