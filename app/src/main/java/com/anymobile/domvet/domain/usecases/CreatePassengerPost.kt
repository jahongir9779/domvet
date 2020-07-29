package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.repository.PassengerPostRepository


/** User Login Use Case
 *
 */
class CreatePassengerPost(val repositoryPassenger: PassengerPostRepository) :
    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<String>>() {

    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<String> {
        return repositoryPassenger.createPassengerPost(params[Constants.TXT_TOKEN] as String,
                                                 params[Constants.TXT_PASSENGER_POST] as PassengerPost)

    }
}