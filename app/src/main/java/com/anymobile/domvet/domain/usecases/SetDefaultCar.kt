package com.anymobile.domvet.domain.usecases
//
//import com.anymobile.domvet.util.Constants
//import com.anymobile.domvet.util.ResultWrapper
//import com.anymobile.domvet.domain.repository.CarRepository
//
//
///** User Login Use Case
// *
// */
//class SetDefaultCar(val repository: CarRepository) :
//    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<String>>() {
//
//    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<String> {
//        return repository.setDefaultCar(params[Constants.TXT_TOKEN] as String, params[Constants.TXT_ID] as Long )
//    }
//}