package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.CarModel
import com.sablab.domvetdoctor.domain.repository.CarRepository
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.models.City


/** User Login Use Case
 *
 */
class UpdateUser(val repository: UserRepository) :
    UseCaseWithParams<City, ResultWrapper<Boolean>>() {

    override suspend fun buildUseCase(params: City): ResultWrapper<Boolean> {
        return repository.updateUserCity(params)
    }
}