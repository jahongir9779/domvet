package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.repository.PassengerPostRepository


/** User Login Use Case
 *
 */
class GetHistoryPassengerPost(val repositoryPassenger: PassengerPostRepository) :
    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<List<PassengerPost>>>() {

    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<List<PassengerPost>> {
        return repositoryPassenger.getHistoryPassengerPosts(params[Constants.TXT_TOKEN] as String,
                                                      params[Constants.TXT_LANG] as String,
                                                      params[Constants.TXT_PAGE] as Int)
    }
}