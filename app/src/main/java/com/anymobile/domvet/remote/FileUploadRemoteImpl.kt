package com.anymobile.domvet.remote

import com.anymobile.domvet.data.repository.FileUploadRemote
import com.anymobile.domvet.domain.model.PhotoBody
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject


/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class FileUploadRemoteImpl @Inject constructor(private val apiService: ApiService) :
    FileUploadRemote {


    override suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody> {
        return try {
            val requestFile = RequestBody.create(MediaType.parse("image/jpg"), file)
            val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
            val response = apiService.uploadPhoto(body)
            if (response.code == 1) ResultWrapper.Success(response.data!!)
            else ErrorWrapper.ResponseError(response.code, response.message)
        } catch (e: Exception) {
            ErrorWrapper.SystemError(e)
        }
    }

}