package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.data.repository.UserDataStore
import com.sablab.domvetdoctor.data.repository.UserRemote
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.network.NUser
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

//    override suspend fun userRegister(user: User): ResultWrapper<String>  {
//        return userRemote.registerUser(user)
//    }

    override suspend fun confirmSms(userCredentialsEntity: UserCredentials): ResultWrapper<NUser> {
        return userRemote.confirmUser(userCredentialsEntity)
    }
//
//    override fun isCached(): Single<Boolean> {
//        throw UnsupportedOperationException()
//    }

}