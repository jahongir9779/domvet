package com.anymobile.domvet.domain.usecases
//
//import com.anymobile.domvet.util.Constants
//import com.anymobile.domvet.util.ResultWrapper
//import com.anymobile.domvet.domain.model.Car
//import com.anymobile.domvet.domain.repository.CarRepository
//
//
///** User Login Use Case
// *
// */
//class SaveCar(val repository: CarRepository) :
//    UseCaseWithParams<HashMap<String, Any>, ResultWrapper<String>>() {
//
//    override suspend fun buildUseCase(params: HashMap<String, Any>): ResultWrapper<String> {
//        return if ((params[Constants.TXT_CAR] as Car).id == null)
//            repository.createCar(params[Constants.TXT_TOKEN] as String,
//                                 params[Constants.TXT_CAR] as Car)
//        else repository.updateCar(params[Constants.TXT_TOKEN] as String,
//                                  params[Constants.TXT_CAR] as Car)
//
//    }
//}