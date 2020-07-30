package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.util.ResultWrapper


/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface UserRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    suspend fun loginUser(phoneNum: String): ResultWrapper<String>

//    suspend fun registerUser(user: User): ResultWrapper<String>
    suspend fun confirmUser(user: UserCredentials): ResultWrapper<NUser>

}