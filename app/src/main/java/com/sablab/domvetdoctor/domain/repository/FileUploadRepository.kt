package com.sablab.domvetdoctor.domain.repository

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.PhotoBody
import java.io.File

interface FileUploadRepository {

    suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody>

}