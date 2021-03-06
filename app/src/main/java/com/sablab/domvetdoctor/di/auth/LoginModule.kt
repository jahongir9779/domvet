package com.sablab.domvetdoctor.di.auth

import com.sablab.domvetdoctor.cache.UserCacheImpl
import com.sablab.domvetdoctor.cache.db.AppDatabase
import com.sablab.domvetdoctor.data.UserRepositoryImpl
import com.sablab.domvetdoctor.data.repository.UserCache
import com.sablab.domvetdoctor.data.repository.UserRemote
import com.sablab.domvetdoctor.data.source.UserCacheDataStore
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
object LoginModule {

    @AuthScope
    @Provides
    @JvmStatic
    fun provideLogUserInUseCase(userRepository: UserRepository): LogUserIn {
        return LogUserIn(userRepository)
    }


    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserRepository(userDataStr: UserDataStoreFactory): UserRepository {
        return UserRepositoryImpl(userDataStr)
    }

    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserDataStoreFactory(cacheDataStore: UserCacheDataStore, userRemoteDataStore: UserRemoteDataStore): UserDataStoreFactory {
        return UserDataStoreFactory(cacheDataStore, userRemoteDataStore)
    }


    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserCacheDataStore(cache: UserCache): UserCacheDataStore {
        return UserCacheDataStore(cache)
    }

    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserCache(): UserCache {
        return UserCacheImpl(AppDatabase.INSTANCE!!)
    }

    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserRemoteDataStore(userRemote: UserRemote): UserRemoteDataStore {
        return UserRemoteDataStore(userRemote)
    }

    @AuthScope
    @Provides
    @JvmStatic
    fun provideUserRemote(apiService: ApiService): UserRemote {
        return UserRemoteImpl(apiService)
    }


    @AuthScope
    @Provides
    @JvmStatic
    fun provideSmsConfirm(userRepository: UserRepository): SmsConfirm {
        return SmsConfirm(userRepository)
    }

}