package com.sablab.domvetdoctor.data.source

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.data.repository.*
import com.sablab.domvetdoctor.domain.model.PhotoBody
import java.io.File
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class FileUploadRemoteDataStore @Inject constructor(private val fileUploadRemote: FileUploadRemote) :
    FileUploadDataStore {

    override suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody> {
        return fileUploadRemote.uploadPhoto(file)
    }



}