package com.anymobile.domvet.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anymobile.domvet.di.viewmodels.MainViewModelFactory
import com.anymobile.domvet.ui.main.MainViewModel
import com.anymobile.domvet.ui.main.mytrips.MyTripsViewModel
import com.anymobile.domvet.ui.main.mytrips.activetrips.ActiveTripsViewModel
import com.anymobile.domvet.ui.main.mytrips.historytrips.HistoryTripsViewModel
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
    @MainViewModelKey(MyTripsViewModel::class)
    abstract fun bindMyTripsViewModel(viewModel: MyTripsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(ActiveTripsViewModel::class)
    abstract fun bindActiveTripsViewModel(viewModel: ActiveTripsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(HistoryTripsViewModel::class)
    abstract fun bindHistoryTripsViewModel(viewModel: HistoryTripsViewModel): ViewModel

}