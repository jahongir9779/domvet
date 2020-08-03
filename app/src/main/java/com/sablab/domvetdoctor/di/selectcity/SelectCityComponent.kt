package com.sablab.domvetdoctor.di.selectcity

import com.sablab.domvetdoctor.ui.selectcity.SelectCityActivity
import dagger.Subcomponent

@SelectCityScope
@Subcomponent(modules = [SelectCityModule::class, SelectCityViewModelModule::class])
interface SelectCityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SelectCityComponent
    }

    fun inject(selectCityActivity: SelectCityActivity)

}
