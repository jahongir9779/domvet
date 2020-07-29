package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.PhotoBody
import com.anymobile.domvet.domain.repository.FileUploadRepository
import java.io.File


/** User Login Use Case
 *
 */
class UploadPhoto(val repository: FileUploadRepository) :
    UseCaseWithParams<File, ResultWrapper<PhotoBody>>() {

    override suspend fun buildUseCase(params: File): ResultWrapper<PhotoBody> {
        return repository.uploadPhoto(params)
    }
}