package com.anymobile.domvet.di

import com.anymobile.domvet.di.addPost.AddPostComponent
import com.anymobile.domvet.di.auth.AuthComponent
import com.anymobile.domvet.di.main.MainComponent
import dagger.Module

/**
 * Created by jahon on 09-Apr-20
 */

@Module(subcomponents = [AuthComponent::class, MainComponent::class, /*AddCarComponent::class,*/ AddPostComponent::class])
class SubComponentsModule