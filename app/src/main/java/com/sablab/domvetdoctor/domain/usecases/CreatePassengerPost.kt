package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.domain.repository.PassengerPostRepository


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