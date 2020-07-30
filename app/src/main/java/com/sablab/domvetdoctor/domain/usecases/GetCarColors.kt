package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.CarColor
import com.sablab.domvetdoctor.domain.repository.CarRepository


/** User Login Use Case
 *
 */
class GetCarColors(val repository: CarRepository) :
    UseCaseWithParams<HashMap<String, String>, ResultWrapper<List<CarColor>>>() {

    override suspend fun buildUseCase(params: HashMap<String, String>): ResultWrapper<List<CarColor>> {
        return repository.getCarColors(params[Constants.TXT_TOKEN]!!, params[Constants.TXT_LANG]!!)
    }
}