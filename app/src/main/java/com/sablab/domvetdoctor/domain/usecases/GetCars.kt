package com.sablab.domvetdoctor.domain.usecases
//
//import com.sablab.domvetdoctor.util.ResultWrapper
//import com.sablab.domvetdoctor.domain.model.CarDetails
//import com.sablab.domvetdoctor.domain.repository.CarRepository
//
//
///** User Login Use Case
// *
// */
//class GetCars(val repository: CarRepository) :
//    UseCaseWithParams<String, ResultWrapper<List<CarDetails>>>() {
//
//    override suspend fun buildUseCase(params: String): ResultWrapper<List<CarDetails>> {
//        return repository.getCars(params)
//    }
//}