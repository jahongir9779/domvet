package com.sablab.domvetdoctor.di.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.viewmodels.RegistrationViewModelFactory
import com.sablab.domvetdoctor.ui.registration.RegistrationViewModel
import com.sablab.domvetdoctor.ui.registration.addyourphoto.AddYourPhotoViewModel
import com.sablab.domvetdoctor.ui.registration.docsandcertificates.DocsAndCertificatesViewModel
import com.sablab.domvetdoctor.ui.registration.passportphoto.PassportPhotoViewModel
import com.sablab.domvetdoctor.ui.registration.personalinfo.PersonalInfoViewModel
import com.sablab.domvetdoctor.ui.registration.selectcity.SelectCityViewModel
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
    abstract fun bindAddYourPhotoViewModel(viewModel: AddYourPhotoViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(DocsAndCertificatesViewModel::class)
    abstract fun bindDocsAndCertificatesViewModel(viewModel: DocsAndCertificatesViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(PassportPhotoViewModel::class)
    abstract fun bindPassportPhotoViewModel(viewModel: PassportPhotoViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(PersonalInfoViewModel::class)
    abstract fun bindPersonalInfoViewModel(viewModel: PersonalInfoViewModel): ViewModel

    @RegistrationScope
    @Binds
    @IntoMap
    @RegistrationViewModelKey(SelectCityViewModel::class)
    abstract fun bindSelectCityViewModel(viewModel: SelectCityViewModel): ViewModel



}