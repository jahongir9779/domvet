package com.anymobile.domvet.data

import com.anymobile.domvet.data.source.UserDataStoreFactory
import com.anymobile.domvet.domain.model.AuthBody
import com.anymobile.domvet.domain.model.Car
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.model.UserCredentials
import com.anymobile.domvet.domain.repository.UserRepository
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
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

    override suspend fun registerUser(user: User): ResultWrapper<String> {
        return factory.retrieveDataStore(false).userRegister(user)
    }

    override suspend fun smsConfirm(userCredentials: UserCredentials): ResultWrapper<AuthBody> {

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


    override fun updateUserDetails(user: User): ResultWrapper<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addOrUpdateUserCar(car: Car): ResultWrapper<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserCars(userId: String): ResultWrapper<List<Car>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUserCar(carId: String): ResultWrapper<List<Car>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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