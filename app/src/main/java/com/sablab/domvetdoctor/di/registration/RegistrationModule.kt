package com.sablab.domvetdoctor.di.registration

import android.content.Context
import com.sablab.domvetdoctor.cache.db.AppDatabase
import com.sablab.domvetdoctor.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
object RegistrationModule {

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