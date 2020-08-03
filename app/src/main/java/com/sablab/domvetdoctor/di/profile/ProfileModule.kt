package com.sablab.domvetdoctor.di.profile

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
object ProfileModule {



}