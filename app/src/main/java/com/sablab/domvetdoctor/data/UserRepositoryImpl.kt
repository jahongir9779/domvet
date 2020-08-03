package com.sablab.domvetdoctor.data

import com.sablab.domvetdoctor.data.source.UserDataStoreFactory
import com.sablab.domvetdoctor.domain.model.Car
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.models.User
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Provides an implementation of the [UserRepository] interface for communicating to and from
 * data sources
 */
class UserRepositoryImpl @Inject constructor(private val factory: UserDataStoreFactory) :
    UserRepository {

    override suspend fun loginUser(phoneNum: String): ResultWrapper<String> {
        return factory.retrieveDataStore(false).userLogin(phoneNum)
    }

//    override suspend fun registerUser(user: User): ResultWrapper<String> {
//        return factory.retrieveDataStore(false).userRegister(user)
//    }

    override suspend fun smsConfirm(userCredentials: UserCredentials): ResultWrapper<NUser> {

        val response = factory.retrieveDataStore(false)
            .confirmSms(userCredentials)

        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> ResultWrapper.Success(response.value)
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }

//        return factory.retrieveDataStore(false).confirmSms(userCredentialsMapper.mapToEntity(userCredentials))
    }

    override suspend fun updateUserCity(city: City): ResultWrapper<Boolean> {
        TODO("Not yet implemented")
    }





//    override fun clearUsers(): Completable {
//        return factory.retrieveCacheDataStore().clearUsers()
//    }
//
//    override fun saveUsers(bufferoos: List<User>): Completable {
//        val bufferooEntities = mutableListOf<UserEntity>()
//        bufferoos.map { bufferooEntities.add(bufferooMapper.mapToEntity(it)) }
//        return factory.retrieveCacheDataStore().saveUsers(bufferooEntities)
//    }
//
//    override fun getUsers(): Flowable<List<User>> {
//        return factory.retrieveCacheDataStore().isCached()
//            .flatMapPublisher {
//                factory.retrieveDataStore(it).getUsers()
//            }
//            .flatMap {
//                Flowable.just(it.map { bufferooMapper.mapFromEntity(it) })
//            }
//            .flatMap {
//                saveUsers(it).toSingle { it }.toFlowable()
//            }
//    }

}