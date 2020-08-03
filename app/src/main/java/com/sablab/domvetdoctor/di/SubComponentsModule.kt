package com.sablab.domvetdoctor.di

import com.sablab.domvetdoctor.di.auth.AuthComponent
import com.sablab.domvetdoctor.di.call.CallComponent
import com.sablab.domvetdoctor.di.main.MainComponent
import com.sablab.domvetdoctor.di.profile.ProfileComponent
import com.sablab.domvetdoctor.di.registration.RegistrationComponent
import com.sablab.domvetdoctor.di.selectcity.SelectCityComponent
import dagger.Module

/**
 * Created by jahon on 09-Apr-20
 */

@Module(subcomponents = [AuthComponent::class, ProfileComponent::class, CallComponent::class, RegistrationComponent::class, SelectCityComponent::class, MainComponent::class])
class SubComponentsModule