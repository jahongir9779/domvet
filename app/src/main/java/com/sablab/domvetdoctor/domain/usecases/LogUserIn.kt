package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.repository.UserRepository


/** User Login Use Case
 *
 */
class LogUserIn(val repository: UserRepository) :
    UseCaseWithParams<String, ResultWrapper<String>>() {

    override suspend fun buildUseCase(params: String): ResultWrapper<String> {
        if (params.length != 11) {
            return ErrorWrapper.ResponseError(Constants.errPhoneFormat)
        }
        return repository.loginUser(params)
    }

}