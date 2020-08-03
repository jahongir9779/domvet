package com.sablab.domvetdoctor.remote

import android.graphics.Bitmap
import com.sablab.domvetdoctor.data.repository.UserRemote
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.models.User
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.remote.model.LoginRequest
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
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

    override suspend fun saveUserCity(city: City): ResultWrapper<NUser> {
        return try {
            val response = apiService.saveUserCity(mapOf("city_id" to city.cityId))
            if (response.isSuccessful) ResultWrapper.Success(response.body()!!)
            else ErrorWrapper.ResponseError(response.code(), response.message())
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

    override suspend fun saveUser(user: User, image: Bitmap): ResultWrapper<NUser> {
        return try {


            val map: MutableMap<String, RequestBody> = HashMap()
            if (user.email!!.isNotEmpty())
                map["email"] =user. email!!.toRequestBody()
            if (user.firstName!!.isNotEmpty())
                map["first_name"] = user.firstName!!.toRequestBody()
            if (user.middleName!!.isNotEmpty())
                map["middle_name"] = user.middleName!!.toRequestBody()
            if (user.lastName!!.isNotEmpty())
                map["last_name"] = user.lastName!!.toRequestBody()

            map["city_id"] = user.cityId!!.toRequestBody()

            val bos = ByteArrayOutputStream()
            image.compress(Bitmap.CompressFormat.JPEG, 100, bos)

            if (bos.size() > 0) {
                val fileBody: RequestBody = bos.toByteArray().toRequestBody()
                map["avatar\"; filename=\"pp.JPG\""] = fileBody
            }

            val response = apiService.saveUser(map)
            if (response.isSuccessful) ResultWrapper.Success(response.body()!!)
            else ErrorWrapper.ResponseError(response.code(), response.message())
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

}