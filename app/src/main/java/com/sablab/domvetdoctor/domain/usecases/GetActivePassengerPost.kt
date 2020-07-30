package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.DriverPost
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.domain.repository.DriverPostRepository
import com.sablab.domvetdoctor.domain.repository.PassengerPostRepository


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