package com.sablab.domvetdoctor.di.call

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.CallViewModelFactory
import com.sablab.domvetdoctor.di.viewmodels.SelectCityViewModelFactory
import com.sablab.domvetdoctor.ui.calldone.CallDoneViewModel
import com.sablab.domvetdoctor.ui.callreadmore.CallReadMoreViewModel
import com.sablab.domvetdoctor.ui.selectcity.SelectCityActViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CallViewModelModule {

    @CallScope
    @Binds
    abstract fun bindViewModelFactory(factory: CallViewModelFactory): ViewModelProvider.Factory

    @CallScope
    @Binds
    @IntoMap
    @CallViewModelKey(CallDoneViewModel::class)
    abstract fun bindCallDoneViewModel(viewModel: CallDoneViewModel): ViewModel


    @CallScope
    @Binds
    @IntoMap
    @CallViewModelKey(CallReadMoreViewModel::class)
    abstract fun bindCallReadMoreViewModel(viewModel: CallReadMoreViewModel): ViewModel


}