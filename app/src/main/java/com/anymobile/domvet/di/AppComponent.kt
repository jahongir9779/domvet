package com.anymobile.domvet.di

import android.app.Application
import com.anymobile.domvet.di.addPost.AddPostComponent
import com.anymobile.domvet.di.auth.AuthComponent
import com.anymobile.domvet.di.main.MainComponent
import com.anymobile.domvet.ui.BaseActivity
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
