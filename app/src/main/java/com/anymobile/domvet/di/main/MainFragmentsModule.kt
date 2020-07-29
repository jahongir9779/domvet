package com.anymobile.domvet.di.main

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.anymobile.domvet.fragments.MainFragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object MainFragmentsModule {

    @JvmStatic
    @MainScope
    @Provides
    @Named("MainFragmentFactory")
    fun provideMainFragmentFactory(viewModelFactory: ViewModelProvider.Factory): FragmentFactory {
        return MainFragmentFactory(
            viewModelFactory)
    }


}