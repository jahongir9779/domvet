package com.badcompany.pitakpass.data.source

import com.badcompany.pitakpass.util.ResultWrapper
import com.badcompany.pitakpass.data.model.AuthEntity
import com.badcompany.pitakpass.data.model.UserCredentialsEntity
import com.badcompany.pitakpass.data.model.UserEntity
import com.badcompany.pitakpass.data.repository.UserDataStore
import com.badcompany.pitakpass.data.repository.UserRemote
import com.badcompany.pitakpass.domain.domainmodel.AuthBody
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class UserRemoteDataStore @Inject constructor(private val userRemote: UserRemote) :
    UserDataStore {

//    override fun clearBufferoos(): Completable {
//        throw UnsupportedOperationException()
//    }
//
//    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
//        throw UnsupportedOperationException()
//    }
//
//    /**
//     * Retrieve a list of [BufferooEntity] instances from the API
//     */
    override suspend fun userLogin(phoneNum: String): ResultWrapper<String> {
        return userRemote.loginUser(phoneNum)
    }

    override suspend fun userRegister(user: UserEntity): ResultWrapper<String>  {
        return userRemote.registerUser(user)
    }
    override suspend fun confirmSms(userCredentialsEntity: UserCredentialsEntity): ResultWrapper<AuthEntity> {
        return userRemote.confirmUser(userCredentialsEntity)
    }
//
//    override fun isCached(): Single<Boolean> {
//        throw UnsupportedOperationException()
//    }

}