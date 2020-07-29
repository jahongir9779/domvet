package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.repository.DriverPostRepository
import com.anymobile.domvet.domain.repository.PassengerPostRepository


/** User Login Use Case
 *
 */
class GetActivePassengerPost(val repositoryPassenger: PassengerPostRepository) :
    UseCaseWithParams<HashMap<String, String>, ResultWrapper<List<PassengerPost>>>() {

    override suspend fun buildUseCase(params: HashMap<String, String>): ResultWrapper<List<PassengerPost>> {
        return repositoryPassenger.getActivePassengerPosts(params[Constants.TXT_TOKEN] as String,
                                                     params[Constants.TXT_LANG] as String)
    }
}