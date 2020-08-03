package com.sablab.domvetdoctor


//import com.sablab.domvetdoctor.di.addcar.AddCarComponent
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.onesignal.OneSignal
import com.sablab.domvetdoctor.di.AppComponent
import com.sablab.domvetdoctor.di.DaggerAppComponent
import com.sablab.domvetdoctor.di.auth.AuthComponent
import com.sablab.domvetdoctor.di.call.CallComponent
import com.sablab.domvetdoctor.di.main.MainComponent
import com.sablab.domvetdoctor.di.profile.ProfileComponent
import com.sablab.domvetdoctor.di.registration.RegistrationComponent
import com.sablab.domvetdoctor.di.selectcity.SelectCityComponent

/**
 * Created by jahon on 13-Mar-18.
 */

open class App : Application() {

    lateinit var appComponent: AppComponent
    private var authComponent: AuthComponent? = null
    private var selectCityComponent: SelectCityComponent? = null
    private var registrationComponent: RegistrationComponent? = null
    private var mainComponent: MainComponent? = null
    private var profileComponent: ProfileComponent? = null
    private var callComponent: CallComponent? = null


    companion object {
        lateinit var uuid: String
        private var INSTANCE: App? = null

        const val TYPE_CONSUMER = 1
        const val TYPE_DOCTOR = 2

        fun getSharedPreferences(name: String, mode: Int): SharedPreferences? =
            INSTANCE?.getSharedPreferences(name, mode)

        fun getResources() = INSTANCE?.resources
        fun getAppContext() = INSTANCE
        fun getInstance(): Context? = INSTANCE
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
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

    fun releaseRegistrationComponent() {
        registrationComponent = null
    }

    fun authComponent(): AuthComponent {
        if (authComponent == null) {
            authComponent = appComponent.authComponent().create()
        }
        return authComponent as AuthComponent
    }

    fun registrationComponent(): RegistrationComponent {
        if (registrationComponent == null) {
            registrationComponent = appComponent.registrationComponent().create()
        }
        return registrationComponent as RegistrationComponent
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

    fun selectCityComponent(): SelectCityComponent {
        if (selectCityComponent == null) {
            selectCityComponent = appComponent.selectCityComponent().create()
        }
        return selectCityComponent as SelectCityComponent
    }

    fun releaseSelectCityComponent() {
        selectCityComponent == null
    }

    fun profileComponent(): ProfileComponent {
        if (profileComponent == null) {
            profileComponent = appComponent.profileComponent().create()
        }
        return profileComponent as ProfileComponent
    }

    fun releaseProfileComponent() {
        profileComponent == null
    }

    fun callComponent(): CallComponent {
        if (callComponent == null) {
            callComponent = appComponent.callComponent().create()
        }
        return callComponent as CallComponent
    }

    fun releasecallComponent() {
        callComponent == null
    }

    fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}


