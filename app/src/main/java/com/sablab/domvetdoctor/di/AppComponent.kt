package com.sablab.domvetdoctor.di

import android.app.Application
import com.sablab.domvetdoctor.di.auth.AuthComponent
import com.sablab.domvetdoctor.di.call.CallComponent
import com.sablab.domvetdoctor.di.main.MainComponent
import com.sablab.domvetdoctor.di.profile.ProfileComponent
import com.sablab.domvetdoctor.di.registration.RegistrationComponent
import com.sablab.domvetdoctor.di.selectcity.SelectCityComponent
import com.sablab.domvetdoctor.ui.BaseActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, SubComponentsModule::class])
interface AppComponent {

    @Component.Builder interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }


    fun inject(activity: BaseActivity)
    fun authComponent(): AuthComponent.Factory
    fun registrationComponent(): RegistrationComponent.Factory
    fun selectCityComponent(): SelectCityComponent.Factory
    fun mainComponent(): MainComponent.Factory
    fun callComponent(): CallComponent.Factory
    fun profileComponent(): ProfileComponent.Factory



}
