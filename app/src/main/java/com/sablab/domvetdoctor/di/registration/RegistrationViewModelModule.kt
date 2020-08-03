package com.sablab.domvetdoctor.di.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.RegistrationViewModelFactory
import com.sablab.domvetdoctor.ui.registration.RegistrationViewModel
import com.sablab.domvetdoctor.ui.registration.addyourphoto.AddYourPhotoViewModel
import com.sablab.domvetdoctor.ui.registration.docsandcertificates.DocsAndCertificatesViewModel
import com.sablab.domvetdoctor.ui.registration.biography.BiographyFragViewModel
import com.sablab.domvetdoctor.ui.registration.myregions.MyRegionsFragViewModel
import com.sablab.domvetdoctor.ui.registration.passportphoto.PassportPhotoViewModel
import com.sablab.domvetdoctor.ui.registration.personalinfo.PersonalInfoViewModel
import com.sablab.domvetdoctor.ui.registration.schedule.ScheduleViewModel
import com.sablab.domvetdoctor.ui.registration.selectcity.SelectCityFragViewModel
import com.sablab.domvetdoctor.ui.registration.serviceprice.ServicePriceFragViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegistrationViewModelModule {

    @RegistrationScope
    @Binds
    abstract fun bindViewModelFactory(factory: RegistrationViewModelFactory) : ViewModelProvider.Factory

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(RegistrationViewModel::class)
    abstract fun bindRegistrationViewModel(viewModel: RegistrationViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(AddYourPhotoViewModel::class)
    abstract fun bindAddYourPhotoViewModel(fragViewModel: AddYourPhotoViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(DocsAndCertificatesViewModel::class)
    abstract fun bindDocsAndCertificatesViewModel(fragViewModel: DocsAndCertificatesViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(PassportPhotoViewModel::class)
    abstract fun bindPassportPhotoViewModel(fragViewModel: PassportPhotoViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(PersonalInfoViewModel::class)
    abstract fun bindPersonalInfoViewModel(fragViewModel: PersonalInfoViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(SelectCityFragViewModel::class)
    abstract fun bindSelectCityFragViewModel(fragViewModel: SelectCityFragViewModel): ViewModel


    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(ServicePriceFragViewModel::class)
    abstract fun bindServicePriceViewModel(fragViewModel: ServicePriceFragViewModel): ViewModel



    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(ScheduleViewModel::class)
    abstract fun bindScheduleViewModel(fragViewModel: ScheduleViewModel): ViewModel



    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(MyRegionsFragViewModel::class)
    abstract fun bindMyRegionsViewModel(fragViewModel: MyRegionsFragViewModel): ViewModel



    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(BiographyFragViewModel::class)
    abstract fun bindEducationViewModel(fragViewModel: BiographyFragViewModel): ViewModel



}