package com.sablab.domvetdoctor.di.profile

import com.sablab.domvetdoctor.ui.biography.BiographyActivity
import com.sablab.domvetdoctor.ui.editserviceprice.EditServicePricesActivity
import com.sablab.domvetdoctor.ui.myregions.MyRegionsActivity
import com.sablab.domvetdoctor.ui.personalmaterials.PersonalMaterialsActivity
import com.sablab.domvetdoctor.ui.schedule.ScheduleActivity
import com.sablab.domvetdoctor.ui.serviceprice.ServicePricesActivity
import dagger.Subcomponent

@ProfileScope
@Subcomponent(modules = [ProfileModule::class, ProfileViewModelModule::class])
interface ProfileComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProfileComponent
    }

    fun inject(biographyActivity: BiographyActivity)
    fun inject(editServicePricesActivity: EditServicePricesActivity)
    fun inject(myRegionsActivity: MyRegionsActivity)
    fun inject(personalMaterialsActivity: PersonalMaterialsActivity)
    fun inject(servicePricesActivity: ServicePricesActivity)
    fun inject(scheduleActivity: ScheduleActivity)

}
