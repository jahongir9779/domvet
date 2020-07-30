package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.domain.model.DriverPost
import com.sablab.domvetdoctor.domain.model.Filter
import com.sablab.domvetdoctor.domain.repository.DriverPostRepository
import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper

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