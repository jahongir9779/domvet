package com.anymobile.domvet.di.auth

import com.anymobile.domvet.data.UserRepositoryImpl
import com.anymobile.domvet.data.repository.UserRemote
import com.anymobile.domvet.data.source.UserDataStoreFactory
import com.anymobile.domvet.data.source.UserRemoteDataStore
import com.anymobile.domvet.domain.repository.UserRepository
import com.anymobile.domvet.domain.usecases.RegisterUser
import com.anymobile.domvet.BuildConfig
import com.anymobile.domvet.remote.ApiService
import com.anymobile.domvet.remote.ApiServiceFactory
import com.anymobile.domvet.remote.UserRemoteImpl
import dagger.Module
import dagger.Provides

@Module
object RegisterModule {

    @AuthScope
    @Provides
    @JvmStatic
    fun provideRegisterUserUseCase(userRepository: UserRepository): RegisterUser {
        return RegisterUser(userRepository)
    }

    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserRepository(factory: UserDataStoreFactory): UserRepository {
        return UserRepositoryImpl(factory)
    }

    @Provides
    @AuthScope
    @JvmStatic
    fun provideUserDataStoreFactory(userRemoteDataStore: UserRemoteDataStore): UserDataStoreFactory {
        return UserDataStoreFactory(userRemoteDataStore)
    }

    @Provides
    @AuthScope
    @JvmStatic
    fun provideUserRemoteDataStore(userRemote: UserRemote): UserRemoteDataStore {
        return UserRemoteDataStore(userRemote)
    }

    @Provides
    @AuthScope
    @JvmStatic
    fun provideUserRemote(apiService: ApiService): UserRemote {
        return UserRemoteImpl(apiService)
    }


}