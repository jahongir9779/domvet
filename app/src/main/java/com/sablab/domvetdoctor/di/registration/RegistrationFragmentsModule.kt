package com.sablab.domvetdoctor.di.registration

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.fragments.RegistrationFragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object RegistrationFragmentsModule {

    @JvmStatic
    @RegistrationScope
    @Provides
    @Named("RegistrationFragmentFactory")
    fun provideRegistrationFragmentFactory(viewModelFactory: ViewModelProvider.Factory): FragmentFactory {
        return RegistrationFragmentFactory(
            viewModelFactory)
    }


}