package com.sablab.domvetdoctor


//import com.sablab.domvetdoctor.di.addcar.AddCarComponent
import android.app.Application
import com.onesignal.OneSignal
import com.sablab.domvetdoctor.di.AppComponent
import com.sablab.domvetdoctor.di.DaggerAppComponent
import com.sablab.domvetdoctor.di.addPost.AddPostComponent
import com.sablab.domvetdoctor.di.auth.AuthComponent
import com.sablab.domvetdoctor.di.main.MainComponent

/**
 * Created by jahon on 13-Mar-18.
 */

open class App : Application() {

    lateinit var appComponent: AppComponent
    private var authComponent: AuthComponent? = null

    //    private var addCarComponent: AddCarComponent? = null
    private var addPostComponent: AddPostComponent? = null
    private var mainComponent: MainComponent? = null


    companion object {
        lateinit var uuid: String
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()


        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()


        OneSignal.idsAvailable { userId, registrationId ->
            uuid = userId
        }

    }

    fun releaseAuthComponent() {
        authComponent = null
    }

    fun authComponent(): AuthComponent {
        if (authComponent == null) {
            authComponent = appComponent.authComponent().create()
        }
        return authComponent as AuthComponent
    }

    fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = appComponent.mainComponent().create()
        }
        return mainComponent as MainComponent
    }

    fun releaseMainComponent() {
        mainComponent == null
    }

    fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

//    fun releaseAddCarComponent() {
//        addCarComponent = null
//    }

    fun releaseAddPostComponent() {
        addPostComponent = null
    }

//    fun addCarComponent(): AddCarComponent {
//        if (addCarComponent == null) {
//            addCarComponent = appComponent.addCarComponent().create()
//        }
//        return addCarComponent as AddCarComponent
//    }


    fun addPostComponent(): AddPostComponent {
        if (addPostComponent == null) {
            addPostComponent = appComponent.addPostComponent().create()
        }
        return addPostComponent as AddPostComponent
    }


}


