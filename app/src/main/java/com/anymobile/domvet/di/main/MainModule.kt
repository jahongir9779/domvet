package com.anymobile.domvet.di.main

import com.anymobile.domvet.data.DriverPostRepositoryImpl
import com.anymobile.domvet.data.PassengerPostRepositoryImpl
import com.anymobile.domvet.data.PlaceRepositoryImpl
import com.anymobile.domvet.data.repository.DriverPostRemote
import com.anymobile.domvet.data.repository.PassengerPostDataStore
import com.anymobile.domvet.data.repository.PassengerPostRemote
import com.anymobile.domvet.data.repository.PlaceRemote
import com.anymobile.domvet.data.source.*
import com.anymobile.domvet.domain.repository.DriverPostRepository
import com.anymobile.domvet.domain.repository.PassengerPostRepository
import com.anymobile.domvet.domain.repository.PlaceRepository
import com.anymobile.domvet.domain.usecases.*
import com.anymobile.domvet.remote.ApiService
import com.anymobile.domvet.remote.DriverPostRemoteImpl
import com.anymobile.domvet.remote.PassengerPostRemoteImpl
import com.anymobile.domvet.remote.PlaceRemoteImpl
import dagger.Module
import dagger.Provides

@Module
object MainModule {


    @MainScope
    @Provides
    @JvmStatic
    fun provideGetPlacesFeed(placeRepository: PlaceRepository): GetPlacesFeed {
        return GetPlacesFeed(placeRepository)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun providePlaceRepository(factory: PlaceDataStoreFactory): PlaceRepository {
        return PlaceRepositoryImpl(factory)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideGetDriverPostWithFilter(passengerPostRepository: DriverPostRepository): GetDriverPostWithFilter {
        return GetDriverPostWithFilter(passengerPostRepository)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun providePassengerPostRepository(factory: PassengerPostDataStoreFactory): PassengerPostRepository {
        return PassengerPostRepositoryImpl(factory)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun providePassengerPostDataStoreFactory(postDataStore: PassengerPostDataStore): PassengerPostDataStoreFactory {
        return PassengerPostDataStoreFactory(postDataStore)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun providePassengerPostDataStore(passengerPostRemote: PassengerPostRemote): PassengerPostDataStore {
        return PassengerPostRemoteDataStore(passengerPostRemote)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun providePassengerPostRemote(apiService: ApiService): PassengerPostRemote {
        return PassengerPostRemoteImpl(apiService)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideGetActivePassengerPost(driverPostRepository: PassengerPostRepository): GetActivePassengerPost {
        return GetActivePassengerPost(driverPostRepository)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideDeletePassengerPost(driverPostRepository: PassengerPostRepository): DeletePassengerPost {
        return DeletePassengerPost(driverPostRepository)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideFinishPassengerPost(driverPostRepository: PassengerPostRepository): FinishPassengerPost {
        return FinishPassengerPost(driverPostRepository)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideGetHistoryPassengerPost(driverPostRepository: PassengerPostRepository): GetHistoryPassengerPost {
        return GetHistoryPassengerPost(driverPostRepository)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideDriverPostRepository(factory: DriverPostDataStoreFactory): DriverPostRepository {
        return DriverPostRepositoryImpl(factory)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun providePlaceDataStoreFactory(placeRemoteDataStore: PlaceRemoteDataStore): PlaceDataStoreFactory {
        return PlaceDataStoreFactory(placeRemoteDataStore)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun provideDriverPostDataStoreFactory(driverPostRemoteDataStore: DriverPostRemoteDataStore): DriverPostDataStoreFactory {
        return DriverPostDataStoreFactory(driverPostRemoteDataStore)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun providePlaceRemoteDataStore(placeRemote: PlaceRemote): PlaceRemoteDataStore {
        return PlaceRemoteDataStore(placeRemote)
    }

    @Provides
    @MainScope
    @JvmStatic
    fun provideDriverPostRemoteDataStore(driverDriverPostRemote: DriverPostRemote): DriverPostRemoteDataStore {
        return DriverPostRemoteDataStore(driverDriverPostRemote)
    }


    @Provides
    @MainScope
    @JvmStatic
    fun providePlaceRemote(apiService: ApiService): PlaceRemote {
        return PlaceRemoteImpl(apiService)
    }


    @Provides
    @MainScope
    @JvmStatic
    fun provideDriverPostRemote(apiService: ApiService): DriverPostRemote {
        return DriverPostRemoteImpl(apiService)
    }

}