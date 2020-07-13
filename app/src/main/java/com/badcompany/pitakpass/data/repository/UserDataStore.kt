package com.badcompany.pitakpass.data.repository

import com.badcompany.pitakpass.util.ResultWrapper
import com.badcompany.pitakpass.data.model.AuthEntity
import com.badcompany.pitakpass.data.model.UserCredentialsEntity
import com.badcompany.pitakpass.data.model.UserEntity


/**
 * Interface defining methods for the data operations related to Bufferroos.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface UserDataStore {

    suspend fun userLogin(phoneNum: String): ResultWrapper<String>
    suspend fun userRegister(user: UserEntity): ResultWrapper<String>
    suspend fun confirmSms(userCredentialsEntity: UserCredentialsEntity): ResultWrapper<AuthEntity>

}