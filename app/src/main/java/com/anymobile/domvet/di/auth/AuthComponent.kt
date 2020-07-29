package com.anymobile.domvet.di.auth

import com.anymobile.domvet.di.addPost.AddPostFragmentsModule
import com.anymobile.domvet.ui.auth.AuthActivity
import dagger.Subcomponent

@AuthScope
@Subcomponent(modules = [LoginModule::class, RegisterModule::class, AuthViewModelModule::class, AuthFragmentsModule::class])
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(authActivity: AuthActivity)

}
