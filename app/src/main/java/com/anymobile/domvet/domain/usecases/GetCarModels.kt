package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.CarModel
import com.anymobile.domvet.domain.repository.CarRepository


/** User Login Use Case
 *
 */
class GetCarModels(val repository: CarRepository) :
    UseCaseWithParams<HashMap<String, String>, ResultWrapper<List<CarModel>>>() {

    override suspend fun buildUseCase(params: HashMap<String, String>): ResultWrapper<List<CarModel>> {
        return repository.getCarModels(params[Constants.TXT_TOKEN]!!, params[Constants.TXT_LANG]!!)
    }
}