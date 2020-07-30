package com.sablab.domvetdoctor.data.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.PhotoBody
import java.io.File


/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface FileUploadRemote {
    suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody>

}