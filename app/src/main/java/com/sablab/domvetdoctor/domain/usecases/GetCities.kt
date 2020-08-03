package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.domain.repository.CitiesRepository
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.util.ResultWrapper


/** User Login Use Case
 *
 */
class GetCities(val repository: CitiesRepository) : UseCase<ResultWrapper<List<City>>>() {

    override suspend fun buildUseCase(): ResultWrapper<List<City>> {
        return repository.getAllCities()
    }


}