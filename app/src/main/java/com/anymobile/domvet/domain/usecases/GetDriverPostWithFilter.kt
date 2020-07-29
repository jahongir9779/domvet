package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.repository.DriverPostRepository
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper

/** User Login Use Case
 *
 */
class GetDriverPostWithFilter(val repositoryDriver: DriverPostRepository) :
    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<List<DriverPost>>>() {

    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<List<DriverPost>> {
        return repositoryDriver.filterDriverPost(params[Constants.TXT_TOKEN] as String,
                                                 params[Constants.TXT_LANG] as String,
                                                 params[Constants.TXT_FILTER] as Filter)
    }
}