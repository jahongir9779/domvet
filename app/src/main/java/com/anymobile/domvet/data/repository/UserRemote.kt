package com.anymobile.domvet.data.repository

import com.anymobile.domvet.domain.model.AuthBody
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.model.UserCredentials
import com.anymobile.domvet.util.ResultWrapper


/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface UserRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    suspend fun loginUser(phoneNum: String): ResultWrapper<String>

    suspend fun registerUser(user: User): ResultWrapper<String>
    suspend fun confirmUser(user: UserCredentials): ResultWrapper<AuthBody>

}