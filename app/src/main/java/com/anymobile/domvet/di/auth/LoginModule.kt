package com.anymobile.domvet.di.auth

import com.anymobile.domvet.domain.repository.UserRepository
import com.anymobile.domvet.domain.usecases.LogUserIn
import com.anymobile.domvet.domain.usecases.SmsConfirm
import dagger.Module
import dagger.Provides

@Module
object LoginModule {

    @AuthScope
    @Provides
    @JvmStatic
    fun provideLogUserInUseCase(userRepository: UserRepository): LogUserIn {
        return LogUserIn(userRepository)
    }


    @AuthScope
    @Provides
    @JvmStatic
    fun provideSmsConfirm(userRepository: UserRepository): SmsConfirm {
        return SmsConfirm(userRepository)
    }

}