package com.sablab.domvetdoctor.domain.usecases
//
//import com.sablab.domvetdoctor.util.Constants
//import com.sablab.domvetdoctor.util.ResultWrapper
//import com.sablab.domvetdoctor.domain.repository.CarRepository
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