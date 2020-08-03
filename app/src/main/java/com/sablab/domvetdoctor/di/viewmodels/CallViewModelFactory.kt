package com.sablab.domvetdoctor.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.call.CallScope
import com.sablab.domvetdoctor.di.profile.ProfileScope
import com.sablab.domvetdoctor.di.registration.RegistrationScope
import com.sablab.domvetdoctor.di.selectcity.SelectCityScope
import javax.inject.Inject
import javax.inject.Provider

@CallScope
class CallViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass as Class<ViewModel>]
            ?: creators.entries.firstOrNull { (c, _) -> modelClass.isAssignableFrom(c) }?.value
            ?: throw IllegalArgumentException("Unknown model class $modelClass")
        return creator.get() as T
    }
}

