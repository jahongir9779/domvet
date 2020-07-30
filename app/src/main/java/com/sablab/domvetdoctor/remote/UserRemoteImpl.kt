package com.sablab.domvetdoctor.remote

import com.sablab.domvetdoctor.data.repository.UserRemote
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.remote.model.LoginRequest
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class UserRemoteImpl @Inject constructor(private val apiService: ApiService) : UserRemote {

//    /**
//     * Retrieve a list of [Bufferoo] instances from the [BufferooService].
//     */
//    override fun getBufferoos(): Flowable<List<User>> {
//        return bufferooService.getBufferoos()
//                .map { it.team }
//                .map {
//                    val entities = mutableListOf<User>()
//                    it.forEach { entities.add(entityMapper.mapFromRemote(it)) }
//                    entities
//                }
//    }

    override suspend fun loginUser(phoneNum: String): ResultWrapper<String> {
        return try {
            val response = apiService.userLogin(LoginRequest(phoneNum))
            if (response.isSuccessful) ResultWrapper.Success("")
            else ErrorWrapper.ResponseError(response.code(), response.message())
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

//    override suspend fun registerUser(user: User): ResultWrapper<String> {
//        return try {
//            val response = apiService.userRegister(user)
//            if (response.code == 1) ResultWrapper.Success(response.data!!.password!!)
//            else ErrorWrapper.ResponseError(response.code, response.message)
//        } catch (e: Exception) {
//            ErrorWrapper.SystemError(e)
//        }
//    }

    override suspend fun confirmUser(user: UserCredentials): ResultWrapper<NUser> {
        return try {
            val response = apiService.smsConfirm(user)
            if (response.isSuccessful) ResultWrapper.Success(response.body()!!)
            else ErrorWrapper.ResponseError(response.code(), response.message())
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

}