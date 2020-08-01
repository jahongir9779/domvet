package com.sablab.domvetdoctor.di.registration

import com.sablab.domvetdoctor.data.UserRepositoryImpl
import com.sablab.domvetdoctor.data.repository.UserRemote
import com.sablab.domvetdoctor.data.source.UserDataStoreFactory
import com.sablab.domvetdoctor.data.source.UserRemoteDataStore
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.domain.usecases.LogUserIn
import com.sablab.domvetdoctor.domain.usecases.SmsConfirm
import com.sablab.domvetdoctor.remote.ApiService
import com.sablab.domvetdoctor.remote.UserRemoteImpl
import dagger.Module
import dagger.Provides

@Module
object RegistrationModule {

//    @RegistrationScope
//    @Provides
//    @JvmStatic
//    fun provideLogUserInUseCase(userRepository: UserRepository): LogUserIn {
//        return LogUserIn(userRepository)
//    }
//
//
//    @RegistrationScope
//    @Provides
//    @JvmStatic
//    fun provideUserRepository(userDataStr: UserDataStoreFactory): UserRepository {
//        return UserRepositoryImpl(userDataStr)
//    }
//
//    @RegistrationScope
//    @Provides
//    @JvmStatic
//    fun provideUserDataStoreFactory(userRemoteDataStore: UserRemoteDataStore): UserDataStoreFactory {
//        return UserDataStoreFactory(userRemoteDataStore)
//    }
//
//    @RegistrationScope
//    @Provides
//    @JvmStatic
//    fun provideUserRemoteDataStore(userRemote: UserRemote): UserRemoteDataStore {
//        return UserRemoteDataStore(userRemote)
//    }
//
//    @RegistrationScope
//    @Provides
//    @JvmStatic
//    fun provideUserRemote(apiService: ApiService): UserRemote {
//        return UserRemoteImpl(apiService)
//    }
//
//
//    @RegistrationScope
//    @Provides
//    @JvmStatic
//    fun provideSmsConfirm(userRepository: UserRepository): SmsConfirm {
//        return SmsConfirm(userRepository)
//    }

}