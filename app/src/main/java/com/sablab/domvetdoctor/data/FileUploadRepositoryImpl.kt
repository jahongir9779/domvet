package com.sablab.domvetdoctor.data

import com.sablab.domvetdoctor.data.source.FileUploadDataStoreFactory
import com.sablab.domvetdoctor.domain.model.PhotoBody
import com.sablab.domvetdoctor.domain.repository.FileUploadRepository
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import java.io.File
import javax.inject.Inject

/**
 * Provides an implementation of the [UserRepository] interface for communicating to and from
 * data sources
 */
class FileUploadRepositoryImpl @Inject constructor(private val factory: FileUploadDataStoreFactory) :
    FileUploadRepository {

    override suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody> {
        val response = factory.retrieveDataStore(false)
            .uploadPhoto(file)
        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> ResultWrapper.Success(response.value)
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }


}