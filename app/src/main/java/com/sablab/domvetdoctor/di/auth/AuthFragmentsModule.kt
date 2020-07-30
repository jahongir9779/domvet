package com.sablab.domvetdoctor.di.auth

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.fragments.AuthFragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object AuthFragmentsModule {

    @JvmStatic
    @AuthScope
    @Provides
    @Named("AuthFragmentFactory")
    fun provideAuthFragmentFactory(viewModelFactory: ViewModelProvider.Factory): FragmentFactory {
        return AuthFragmentFactory(
            viewModelFactory)
    }


}