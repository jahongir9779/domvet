package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.User
import com.anymobile.domvet.domain.repository.UserRepository


/** User Login Use Case
 *
 */
class RegisterUser(val repository: UserRepository) :
    UseCaseWithParams<User, ResultWrapper<String>>() {

    override suspend fun buildUseCase(params: User): ResultWrapper<String> {
        if (params.phoneNum.length != 12) return ErrorWrapper.ResponseError(Constants.errPhoneFormat)
        return repository.registerUser(params)
    }

}