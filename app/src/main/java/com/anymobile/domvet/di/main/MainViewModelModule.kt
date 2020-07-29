package com.anymobile.domvet.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anymobile.domvet.di.viewmodels.MainViewModelFactory
import com.anymobile.domvet.ui.main.MainViewModel
import com.anymobile.domvet.ui.main.mycalls.MyCallsViewModel
import com.anymobile.domvet.ui.main.mycalls.activecalls.ActiveCallsViewModel
import com.anymobile.domvet.ui.main.mycalls.historycalls.HistoryCallsViewModel
import com.anymobile.domvet.ui.main.profile.ProfileViewModel
import com.anymobile.domvet.ui.main.searchtrip.SearchTripViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @MainViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(SearchTripViewModel::class)
    abstract fun bindSearchTripViewModel(viewModel: SearchTripViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(MyCallsViewModel::class)
    abstract fun bindMyTripsViewModel(viewModel: MyCallsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(ActiveCallsViewModel::class)
    abstract fun bindActiveTripsViewModel(viewModel: ActiveCallsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(HistoryCallsViewModel::class)
    abstract fun bindHistoryTripsViewModel(viewModel: HistoryCallsViewModel): ViewModel

}