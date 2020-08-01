package com.sablab.domvetdoctor.di.registration

import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import dagger.Subcomponent

@RegistrationScope
@Subcomponent(modules = [RegistrationModule::class, RegistrationViewModelModule::class, RegistrationFragmentsModule::class])
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(registrationActivity: RegistrationActivity)

}
