package com.anymobile.domvet.domain.usecases
//
//import com.anymobile.domvet.util.ResultWrapper
//import com.anymobile.domvet.domain.model.CarDetails
//import com.anymobile.domvet.domain.repository.CarRepository
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