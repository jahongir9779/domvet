package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.domain.model.PhotoBody
import com.sablab.domvetdoctor.util.ResultWrapper
import java.io.File


/**
 * Interface defining methods for the data operations related to Bufferroos.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface FileUploadDataStore {

    suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody>

}