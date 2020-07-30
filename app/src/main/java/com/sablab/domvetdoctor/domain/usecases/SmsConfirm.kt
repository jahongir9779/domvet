package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.UserCredentials
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.models.network.NUser


/** User Login Use Case
 *
 */
class SmsConfirm(val repository: UserRepository) :
    UseCaseWithParams<UserCredentials, ResultWrapper<NUser>>() {

    override suspend fun buildUseCase(params: UserCredentials): ResultWrapper<NUser> {
        return repository.smsConfirm(params)
    }

}