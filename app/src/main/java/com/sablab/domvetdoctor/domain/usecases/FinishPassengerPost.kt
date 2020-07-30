package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.repository.PassengerPostRepository


/** User Login Use Case
 *
 */
class FinishPassengerPost(val repositoryPassenger: PassengerPostRepository) :
    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<Int>>() {

    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<Int> {
        val response = repositoryPassenger.finishPassengerPost(params[Constants.TXT_TOKEN] as String,
                                                         params[Constants.TXT_ID] as String)

        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> ResultWrapper.Success(params[Constants.TXT_POSITION] as Int)
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }
    }
}