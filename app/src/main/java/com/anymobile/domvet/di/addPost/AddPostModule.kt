package com.anymobile.domvet.di.addPost

import com.anymobile.domvet.data.PassengerPostRepositoryImpl
import com.anymobile.domvet.data.PlaceRepositoryImpl
import com.anymobile.domvet.data.repository.PlaceRemote
import com.anymobile.domvet.data.repository.PassengerPostRemote
import com.anymobile.domvet.data.source.*
import com.anymobile.domvet.domain.repository.PassengerPostRepository
import com.anymobile.domvet.domain.repository.PlaceRepository
import com.anymobile.domvet.domain.usecases.CreatePassengerPost
import com.anymobile.domvet.domain.usecases.GetPlacesFeed
import com.anymobile.domvet.remote.ApiService
import com.anymobile.domvet.remote.PassengerPostRemoteImpl
import com.anymobile.domvet.remote.PlaceRemoteImpl
import dagger.Module
import dagger.Provides

@Module
object AddPostModule {

    @AddPostScope
    @Provides
    @JvmStatic
    fun provideCreatePassengerPost(driverPostRepository: PassengerPostRepository): CreatePassengerPost {
        return CreatePassengerPost(driverPostRepository)
    }

    @AddPostScope
    @Provides
    @JvmStatic
    fun provideGetPlacesFeed(placeRepository: PlaceRepository): GetPlacesFeed {
        return GetPlacesFeed(placeRepository)
    }

    @AddPostScope
    @Provides
    @JvmStatic
    fun providePlaceRepository(factory: PlaceDataStoreFactory): PlaceRepository {
        return PlaceRepositoryImpl(factory)
    }

    @AddPostScope
    @Provides
    @JvmStatic
    fun providePassengerPostRepository(factory: PassengerPostDataStoreFactory): PassengerPostRepository {
        return PassengerPostRepositoryImpl(factory)
    }

    @Provides
    @AddPostScope
    @JvmStatic
    fun providePlaceDataStoreFactory(placeRemoteDataStore: PlaceRemoteDataStore): PlaceDataStoreFactory {
        return PlaceDataStoreFactory(placeRemoteDataStore)
    }

    @Provides
    @AddPostScope
    @JvmStatic
    fun providePassengerPostDataStoreFactory(driverPostRemoteDataStore: PassengerPostRemoteDataStore): PassengerPostDataStoreFactory {
        return PassengerPostDataStoreFactory(driverPostRemoteDataStore)
    }

    @Provides
    @AddPostScope
    @JvmStatic
    fun providePlaceRemoteDataStore(placeRemote: PlaceRemote): PlaceRemoteDataStore {
        return PlaceRemoteDataStore(placeRemote)
    }

    @Provides
    @AddPostScope
    @JvmStatic
    fun providePassengerPostRemoteDataStore(passengerPassengerPostRemote: PassengerPostRemote): PassengerPostRemoteDataStore {
        return PassengerPostRemoteDataStore(passengerPassengerPostRemote)
    }


    @Provides
    @AddPostScope
    @JvmStatic
    fun providePlaceRemote(apiService: ApiService): PlaceRemote {
        return PlaceRemoteImpl(apiService)
    }


    @Provides
    @AddPostScope
    @JvmStatic
    fun providePassengerPostRemote(apiService: ApiService): PassengerPostRemote {
        return PassengerPostRemoteImpl(apiService)
    }

}