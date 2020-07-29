package com.anymobile.domvet.domain.repository

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.PhotoBody
import java.io.File

interface FileUploadRepository {

    suspend fun uploadPhoto(file: File): ResultWrapper<PhotoBody>

}