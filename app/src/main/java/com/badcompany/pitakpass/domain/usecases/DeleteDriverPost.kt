package com.badcompany.pitakpass.domain.usecases

import com.badcompany.pitakpass.util.Constants
import com.badcompany.pitakpass.util.ErrorWrapper
import com.badcompany.pitakpass.util.ResultWrapper
import com.badcompany.pitakpass.domain.repository.DriverPostRepository


/** User Login Use Case
 *
 */
class DeleteDriverPost(val repositoryDriver: DriverPostRepository) :
    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<Int>>() {

    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<Int> {
        val response = repositoryDriver.deleteDriverPost(params[Constants.TXT_TOKEN] as String,
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