package com.sablab.domvetdoctor.di.addPost

import com.sablab.domvetdoctor.data.PassengerPostRepositoryImpl
import com.sablab.domvetdoctor.data.PlaceRepositoryImpl
import com.sablab.domvetdoctor.data.repository.PlaceRemote
import com.sablab.domvetdoctor.data.repository.PassengerPostRemote
import com.sablab.domvetdoctor.data.source.*
import com.sablab.domvetdoctor.domain.repository.PassengerPostRepository
import com.sablab.domvetdoctor.domain.repository.PlaceRepository
import com.sablab.domvetdoctor.domain.usecases.CreatePassengerPost
import com.sablab.domvetdoctor.domain.usecases.GetPlacesFeed
import com.sablab.domvetdoctor.remote.ApiService
import com.sablab.domvetdoctor.remote.PassengerPostRemoteImpl
import com.sablab.domvetdoctor.remote.PlaceRemoteImpl
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