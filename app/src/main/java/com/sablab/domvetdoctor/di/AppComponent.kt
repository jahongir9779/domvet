package com.sablab.domvetdoctor.di

import android.app.Application
import com.sablab.domvetdoctor.di.addPost.AddPostComponent
import com.sablab.domvetdoctor.di.auth.AuthComponent
import com.sablab.domvetdoctor.di.main.MainComponent
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
    fun mainComponent(): MainComponent.Factory
//    fun addCarComponent(): AddCarComponent.Factory
    fun addPostComponent(): AddPostComponent.Factory

}
