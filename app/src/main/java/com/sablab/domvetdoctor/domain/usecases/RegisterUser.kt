//package com.sablab.domvetdoctor.domain.usecases
//
//import com.sablab.domvetdoctor.util.Constants
//import com.sablab.domvetdoctor.util.ErrorWrapper
//import com.sablab.domvetdoctor.util.ResultWrapper
//import com.sablab.domvetdoctor.domain.model.User
//import com.sablab.domvetdoctor.domain.repository.UserRepository
//
//
///** User Login Use Case
// *
// */
//class RegisterUser(val repository: UserRepository) :
//    UseCaseWithParams<User, ResultWrapper<String>>() {
//
//    override suspend fun buildUseCase(params: User): ResultWrapper<String> {
//        if (params.phoneNum.length != 12) return ErrorWrapper.ResponseError(Constants.errPhoneFormat)
//        return repository.registerUser(params)
//    }
//
//}