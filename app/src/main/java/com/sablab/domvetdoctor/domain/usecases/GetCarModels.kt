package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.CarModel
import com.sablab.domvetdoctor.domain.repository.CarRepository


/** User Login Use Case
 *
 */
class GetCarModels(val repository: CarRepository) :
    UseCaseWithParams<HashMap<String, String>, ResultWrapper<List<CarModel>>>() {

    override suspend fun buildUseCase(params: HashMap<String, String>): ResultWrapper<List<CarModel>> {
        return repository.getCarModels(params[Constants.TXT_TOKEN]!!, params[Constants.TXT_LANG]!!)
    }
}