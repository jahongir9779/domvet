package com.sablab.domvetdoctor.di

import com.sablab.domvetdoctor.BuildConfig
import com.sablab.domvetdoctor.data.CarRepositoryImpl
import com.sablab.domvetdoctor.data.FileUploadRepositoryImpl
import com.sablab.domvetdoctor.data.repository.CarRemote
import com.sablab.domvetdoctor.data.repository.FileUploadRemote
import com.sablab.domvetdoctor.data.source.CarDataStoreFactory
import com.sablab.domvetdoctor.data.source.CarRemoteDataStore
import com.sablab.domvetdoctor.data.source.FileUploadDataStoreFactory
import com.sablab.domvetdoctor.data.source.FileUploadRemoteDataStore
import com.sablab.domvetdoctor.domain.repository.CarRepository
import com.sablab.domvetdoctor.domain.repository.FileUploadRepository
import com.sablab.domvetdoctor.domain.usecases.*
import com.sablab.domvetdoctor.remote.ApiService
import com.sablab.domvetdoctor.remote.ApiServiceFactory
import com.sablab.domvetdoctor.remote.CarRemoteImpl
import com.sablab.domvetdoctor.remote.FileUploadRemoteImpl
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