package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.PhotoBody
import com.sablab.domvetdoctor.domain.repository.FileUploadRepository
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