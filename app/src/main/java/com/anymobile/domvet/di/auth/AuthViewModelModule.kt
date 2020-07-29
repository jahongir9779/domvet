package com.anymobile.domvet.di.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anymobile.domvet.di.viewmodels.AuthViewModelFactory
import com.anymobile.domvet.ui.auth.AuthViewModel
import com.anymobile.domvet.ui.auth.confirm.PhoneConfirmViewModel
import com.anymobile.domvet.ui.auth.login.LoginViewModel
import com.anymobile.domvet.ui.auth.phone.PhoneViewModel
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