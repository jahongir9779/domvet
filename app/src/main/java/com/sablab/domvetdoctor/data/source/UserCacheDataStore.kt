package com.sablab.domvetdoctor.data.source

import android.graphics.Bitmap
import com.sablab.domvetdoctor.cache.db.entries.EUser
import com.sablab.domvetdoctor.data.repository.UserCache
import com.sablab.domvetdoctor.data.repository.UserDataStore
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.models.User
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class UserCacheDataStore @Inject constructor(private val userCache: UserCache) :
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
        throw UnsupportedOperationException()
    }

    override suspend fun confirmSms(userCredentials: UserCredentials): ResultWrapper<NUser> {
        throw UnsupportedOperationException()
    }

    override suspend fun saveUserCity(city: City): ResultWrapper<NUser> {
        throw UnsupportedOperationException()
    }

    override suspend fun saveUser(user: User, image: Bitmap): ResultWrapper<NUser> {
        return ResultWrapper.Success(userCache.saveUser(EUser.makeEUser(user)))
    }

//    override fun isCached(): Single<Boolean> {
//        throw UnsupportedOperationException()
//    }

}