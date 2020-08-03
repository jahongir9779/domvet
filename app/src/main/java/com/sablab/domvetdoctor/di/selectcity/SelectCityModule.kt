package com.sablab.domvetdoctor.di.selectcity

import android.app.Application
import com.sablab.domvetdoctor.cache.UserCacheImpl
import com.sablab.domvetdoctor.cache.db.AppDatabase
import com.sablab.domvetdoctor.data.CitiesRepositoryImpl
import com.sablab.domvetdoctor.data.UserRepositoryImpl
import com.sablab.domvetdoctor.data.repository.CityRemote
import com.sablab.domvetdoctor.data.repository.UserCache
import com.sablab.domvetdoctor.data.repository.UserRemote
import com.sablab.domvetdoctor.data.source.*
import com.sablab.domvetdoctor.domain.repository.CitiesRepository
import com.sablab.domvetdoctor.domain.repository.UserRepository
import com.sablab.domvetdoctor.domain.usecases.GetCities
import com.sablab.domvetdoctor.domain.usecases.UpdateUser
import com.sablab.domvetdoctor.remote.ApiService
import com.sablab.domvetdoctor.remote.CityRemoteImpl
import com.sablab.domvetdoctor.remote.UserRemoteImpl
import dagger.Module
import dagger.Provides

@Module
object SelectCityModule {


    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideGetCities(repository: CitiesRepository): GetCities {
        return GetCities(repository)
    }


    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideCitiesRepository(factory: CityDataStoreFactory): CitiesRepository {
        return CitiesRepositoryImpl(factory)
    }

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideCityDataStoreFactory(dataStore: CityRemoteDataStore): CityDataStoreFactory {
        return CityDataStoreFactory(dataStore)
    }

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideCityRemoteDataStore(remote: CityRemote): CityRemoteDataStore {
        return CityRemoteDataStore(remote)
    }


    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideCityRemote(apiService: ApiService): CityRemote {
        return CityRemoteImpl(apiService)
    }

//----------------------------------------------------USER

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUpdateUser(repository: UserRepository): UpdateUser {
        return UpdateUser(repository)
    }


    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUserRepository(factory: UserDataStoreFactory): UserRepository {
        return UserRepositoryImpl(factory)
    }

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUserDataStoreFactory(cacheDataStore: UserCacheDataStore,
                                    remoteDataStore: UserRemoteDataStore): UserDataStoreFactory {
        return UserDataStoreFactory(cacheDataStore, remoteDataStore)
    }

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUserCacheDataStore(cache: UserCache): UserCacheDataStore {
        return UserCacheDataStore(cache)
    }

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUserRemoteDataStore(remote: UserRemote): UserRemoteDataStore {
        return UserRemoteDataStore(remote)
    }


    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUserRemote(apiService: ApiService): UserRemote {
        return UserRemoteImpl(apiService)
    }

    @SelectCityScope
    @Provides
    @JvmStatic
    fun provideUserCache(application: Application): UserCache {
        return UserCacheImpl(AppDatabase.instance(application))
    }


}