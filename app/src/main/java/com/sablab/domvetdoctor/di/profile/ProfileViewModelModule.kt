package com.sablab.domvetdoctor.di.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.ProfileViewModelFactory
import com.sablab.domvetdoctor.ui.biography.BiographyViewModel
import com.sablab.domvetdoctor.ui.editserviceprice.EditServicePricesViewModel
import com.sablab.domvetdoctor.ui.myregions.MyRegionsViewModel
import com.sablab.domvetdoctor.ui.personalmaterials.PersonalMaterialsViewModel
import com.sablab.domvetdoctor.ui.registration.serviceprice.ServicePriceFragViewModel
import com.sablab.domvetdoctor.ui.schedule.ScheduleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModelModule {

    @ProfileScope
    @Binds
    abstract fun bindViewModelFactory(factory: ProfileViewModelFactory): ViewModelProvider.Factory

    @ProfileScope
    @Binds
    @IntoMap
    @ProfileViewModelKey(BiographyViewModel::class)
    abstract fun bindBiographyViewModel(viewModel: BiographyViewModel): ViewModel

    @ProfileScope
    @Binds
    @IntoMap
    @ProfileViewModelKey(MyRegionsViewModel::class)
    abstract fun bindMyRegionsViewModel(viewModel: MyRegionsViewModel): ViewModel

    @ProfileScope
    @Binds
    @IntoMap
    @ProfileViewModelKey(ServicePriceFragViewModel::class)
    abstract fun bindServicePriceViewModel(viewModel: ServicePriceFragViewModel): ViewModel

    @ProfileScope
    @Binds
    @IntoMap
    @ProfileViewModelKey(EditServicePricesViewModel::class)
    abstract fun bindEditServicePricesViewModel(viewModel: EditServicePricesViewModel): ViewModel

    @ProfileScope
    @Binds
    @IntoMap
    @ProfileViewModelKey(PersonalMaterialsViewModel::class)
    abstract fun bindPersonalMaterialsViewModel(viewModel: PersonalMaterialsViewModel): ViewModel

    @ProfileScope
    @Binds
    @IntoMap
    @ProfileViewModelKey(ScheduleViewModel::class)
    abstract fun bindScheduleViewModel(viewModel: ScheduleViewModel): ViewModel


}