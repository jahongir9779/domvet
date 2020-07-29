package com.anymobile.domvet.data.repository

import com.anymobile.domvet.domain.model.AuthBody
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.model.UserCredentials


/**
 * Interface defining methods for the data operations related to Bufferroos.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface UserDataStore {

    suspend fun userLogin(phoneNum: String): ResultWrapper<String>
    suspend fun userRegister(user: User): ResultWrapper<String>
    suspend fun confirmSms(userCredentials: UserCredentials): ResultWrapper<AuthBody>

}