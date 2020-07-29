package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.repository.PassengerPostRepository


/** User Login Use Case
 *
 */
class DeletePassengerPost(val repositoryPassenger: PassengerPostRepository) :
    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<Int>>() {

    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<Int> {
        val response = repositoryPassenger.deletePassengerPost(params[Constants.TXT_TOKEN] as String,
                                                         params[Constants.TXT_ID] as String)

        return when (response) {
            is ErrorWrapper.ResponseError -> response
            is ErrorWrapper.SystemError -> response
            is ResultWrapper.Success -> {
                ResultWrapper.Success(params[Constants.TXT_POSITION] as Int)
            }
            ResultWrapper.InProgress -> ResultWrapper.InProgress
        }


    }
}