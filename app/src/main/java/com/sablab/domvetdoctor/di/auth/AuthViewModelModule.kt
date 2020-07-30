package com.sablab.domvetdoctor.di.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.AuthViewModelFactory
import com.sablab.domvetdoctor.ui.auth.AuthViewModel
import com.sablab.domvetdoctor.ui.auth.confirm.PhoneConfirmViewModel
import com.sablab.domvetdoctor.ui.auth.login.LoginViewModel
import com.sablab.domvetdoctor.ui.auth.phone.PhoneViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @AuthScope
    @Binds
    abstract fun bindViewModelFactory(factory: AuthViewModelFactory) : ViewModelProvider.Factory

    @AuthScope
    @Binds
    @IntoMap
    @AuthViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @AuthScope
    @Binds
    @IntoMap
    @AuthViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @AuthScope
    @Binds
    @IntoMap
    @AuthViewModelKey(PhoneViewModel::class)
    abstract fun bindPhoneViewModel(viewModel: PhoneViewModel): ViewModel

    @AuthScope
    @Binds
    @IntoMap
    @AuthViewModelKey(PhoneConfirmViewModel::class)
    abstract fun bindPhoneConfirmViewModel(viewModel: PhoneConfirmViewModel): ViewModel


}