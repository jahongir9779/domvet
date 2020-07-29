package com.anymobile.domvet.di

import com.anymobile.domvet.BuildConfig
import com.anymobile.domvet.data.CarRepositoryImpl
import com.anymobile.domvet.data.FileUploadRepositoryImpl
import com.anymobile.domvet.data.repository.CarRemote
import com.anymobile.domvet.data.repository.FileUploadRemote
import com.anymobile.domvet.data.source.CarDataStoreFactory
import com.anymobile.domvet.data.source.CarRemoteDataStore
import com.anymobile.domvet.data.source.FileUploadDataStoreFactory
import com.anymobile.domvet.data.source.FileUploadRemoteDataStore
import com.anymobile.domvet.domain.repository.CarRepository
import com.anymobile.domvet.domain.repository.FileUploadRepository
import com.anymobile.domvet.domain.usecases.*
import com.anymobile.domvet.remote.ApiService
import com.anymobile.domvet.remote.ApiServiceFactory
import com.anymobile.domvet.remote.CarRemoteImpl
import com.anymobile.domvet.remote.FileUploadRemoteImpl
import dagger.Module
import dagger.Provides

@Module
object AppModule {

//
//    @Provides
//    @JvmStatic
//    fun provideGetCars(carRepository: CarRepository): GetCars {
//        return GetCars(carRepository)
//    }
//
//    @Provides
//    @JvmStatic
//    fun provideDeleteCar(carRepository: CarRepository): DeleteCar {
//        return DeleteCar(carRepository)
//    }


    @Provides
    @JvmStatic
    fun provideCarRepository(carDataStoreFactory: CarDataStoreFactory): CarRepository {
        return CarRepositoryImpl(carDataStoreFactory)
    }

    @Provides
    @JvmStatic
    fun provideCarDataStoreFactory(carRemoteDataStore: CarRemoteDataStore): CarDataStoreFactory {
        return CarDataStoreFactory(carRemoteDataStore)
    }


    @Provides

    @JvmStatic
    fun provideCarRemoteDataStore(carRemote: CarRemote): CarRemoteDataStore {
        return CarRemoteDataStore(carRemote)
    }


    @Provides
    @JvmStatic
    fun provideCarRemote(apiService: ApiService): CarRemote {
        return CarRemoteImpl(apiService)
    }


//    @Provides
//    @JvmStatic
//    fun provideSaveCar(carRepository: CarRepository): SaveCar {
//        return SaveCar(carRepository)
//    }
//
//
//    @Provides
//    @JvmStatic
//    fun provideSetDefaultCar(carRepository: CarRepository): SetDefaultCar {
//        return SetDefaultCar(carRepository)
//    }


    @Provides
    @JvmStatic
    fun provideGetCarColorsUseCase(carRepository: CarRepository): GetCarColors {
        return GetCarColors(carRepository)
    }


    @Provides
    @JvmStatic
    fun provideGetCarModelsUseCase(carRepository: CarRepository): GetCarModels {
        return GetCarModels(carRepository)
    }


    @Provides
    @JvmStatic
    fun provideApiService(): ApiService {
        return ApiServiceFactory.makeApiService(BuildConfig.DEBUG)
    }


    @Provides
    @JvmStatic
    fun provideUploadCarPhotoUseCase(fileUploadRepository: FileUploadRepository): UploadPhoto {
        return UploadPhoto(fileUploadRepository)
    }

    @Provides
    @JvmStatic
    fun provideFileUploadRepository(fileUploadDataStoreFactory: FileUploadDataStoreFactory): FileUploadRepository {
        return FileUploadRepositoryImpl(fileUploadDataStoreFactory)
    }


    @Provides
    @JvmStatic
    fun provideFileUploadDataStoreFactory(fileUploadRemoteDataStore: FileUploadRemoteDataStore): FileUploadDataStoreFactory {
        return FileUploadDataStoreFactory(fileUploadRemoteDataStore)
    }

    @Provides
    @JvmStatic
    fun provideFileUploadRemoteDataStore(fileUploadRemote: FileUploadRemote): FileUploadRemoteDataStore {
        return FileUploadRemoteDataStore(fileUploadRemote)
    }

    @Provides
    @JvmStatic
    fun provideFileUploadRemote(apiService: ApiService): FileUploadRemote {
        return FileUploadRemoteImpl(apiService)
    }

//    @Singleton
//    @Provides
//    @JvmStatic
//    fun provideRequestOptions(): RequestOptions {
//        return RequestOptions
//            .placeholderOf(R.drawable.white_background)
//            .error(R.drawable.white_background)
//    }

//    @JvmStatic
//    @Singleton
//    @Provides
//    fun provideGlideInstance(application: Application?,
//                             requestOptions: RequestOptions?): RequestManager {
//        return Glide.with(application!!)
//            .setDefaultRequestOptions(requestOptions!!)
//    }

//    @JvmStatic
//    @Singleton
//    @Provides
//    fun provideAppDrawable(application: Application?): Drawable {
//        return ContextCompat.getDrawable(application!!, R.drawable.logo)
//    }

}