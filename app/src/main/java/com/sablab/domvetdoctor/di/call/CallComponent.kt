package com.sablab.domvetdoctor.di.call

import com.sablab.domvetdoctor.ui.calldone.CallDoneActivity
import com.sablab.domvetdoctor.ui.callreadmore.CallReadMoreActivity
import dagger.Subcomponent

@CallScope
@Subcomponent(modules = [CallModule::class, CallViewModelModule::class])
interface CallComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CallComponent
    }

    fun inject(callDoneActivity: CallDoneActivity)
    fun inject(callReadMoreActivity: CallReadMoreActivity)

}
