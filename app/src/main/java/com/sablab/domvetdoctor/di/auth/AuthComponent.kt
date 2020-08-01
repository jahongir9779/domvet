package com.sablab.domvetdoctor.di.auth

import com.sablab.domvetdoctor.ui.auth.AuthActivity
import dagger.Subcomponent

@AuthScope
@Subcomponent(modules = [LoginModule::class, AuthViewModelModule::class, AuthFragmentsModule::class])
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(authActivity: AuthActivity)

}
