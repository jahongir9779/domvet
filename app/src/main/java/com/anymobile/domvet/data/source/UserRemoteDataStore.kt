package com.anymobile.domvet.data.source

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.data.repository.UserDataStore
import com.anymobile.domvet.data.repository.UserRemote
import com.anymobile.domvet.domain.model.AuthBody
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.model.UserCredentials
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

    override suspend fun userRegister(user: User): ResultWrapper<String>  {
        return userRemote.registerUser(user)
    }
    override suspend fun confirmSms(userCredentialsEntity: UserCredentials): ResultWrapper<AuthBody> {
        return userRemote.confirmUser(userCredentialsEntity)
    }
//
//    override fun isCached(): Single<Boolean> {
//        throw UnsupportedOperationException()
//    }

}