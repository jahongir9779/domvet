package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.AuthBody
import com.anymobile.domvet.domain.model.UserCredentials
import com.anymobile.domvet.domain.repository.UserRepository


/** User Login Use Case
 *
 */
class SmsConfirm(val repository: UserRepository) :
    UseCaseWithParams<UserCredentials, ResultWrapper<AuthBody>>() {

    override suspend fun buildUseCase(params: UserCredentials): ResultWrapper<AuthBody> {
        return repository.smsConfirm(params)
    }

}