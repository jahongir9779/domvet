package com.sablab.domvetdoctor.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.MainViewModelFactory
import com.sablab.domvetdoctor.ui.main.MainViewModel
import com.sablab.domvetdoctor.ui.main.finance.FinanceViewModel
import com.sablab.domvetdoctor.ui.main.mycalls.MyCallsViewModel
import com.sablab.domvetdoctor.ui.main.finance.summary.SummaryViewModel
import com.sablab.domvetdoctor.ui.main.finance.history.HistoryTransactionsViewModel
import com.sablab.domvetdoctor.ui.main.profile.ProfileViewModel
import com.sablab.domvetdoctor.ui.main.doccalls.DocCallsViewModel
import com.sablab.domvetdoctor.ui.main.mycalls.activecalls.ActiveCallsViewModel
import com.sablab.domvetdoctor.ui.main.mycalls.historycalls.HistoryCallsViewModel
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
    @MainViewModelKey(FinanceViewModel::class)
    abstract fun bindFinanceViewModel(viewModel: FinanceViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(DocCallsViewModel::class)
    abstract fun bindSearchTripViewModel(viewModel: DocCallsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(MyCallsViewModel::class)
    abstract fun bindMyTripsViewModel(viewModel: MyCallsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(SummaryViewModel::class)
    abstract fun bindSummaryViewModel(viewModel: SummaryViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(HistoryTransactionsViewModel::class)
    abstract fun bindHistoryTransactionsViewModel(viewModel: HistoryTransactionsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(ActiveCallsViewModel::class)
    abstract fun bindActiveCallsViewModel(viewModel: ActiveCallsViewModel): ViewModel

    @Binds
    @IntoMap
    @MainViewModelKey(HistoryCallsViewModel::class)
    abstract fun bindHistoryCallsViewModel(viewModel: HistoryCallsViewModel): ViewModel

}