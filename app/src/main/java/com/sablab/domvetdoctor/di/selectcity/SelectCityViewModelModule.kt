package com.sablab.domvetdoctor.di.selectcity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.SelectCityViewModelFactory
import com.sablab.domvetdoctor.ui.selectcity.SelectCityActViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SelectCityViewModelModule {

    @SelectCityScope
    @Binds
    abstract fun bindViewModelFactory(factory: SelectCityViewModelFactory): ViewModelProvider.Factory

    @SelectCityScope
    @Binds
    @IntoMap
    @SelectCityViewModelKey(SelectCityActViewModel::class)
    abstract fun bindSelectCityActViewModel(viewModel: SelectCityActViewModel): ViewModel


}