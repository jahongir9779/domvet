package com.sablab.domvetdoctor.fragments

//import com.codingwithmitch.openapi.di.main.MainScope
//import com.codingwithmitch.openapi.ui.main.account.AccountFragment
//import com.codingwithmitch.openapi.ui.main.account.ChangePasswordFragment
//import com.codingwithmitch.openapi.ui.main.account.UpdateAccountFragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.registration.RegistrationScope
import com.sablab.domvetdoctor.ui.registration.addyourphoto.AddYourPhotoFragment
import com.sablab.domvetdoctor.ui.registration.docsandcertificates.DocsAndCertificatesFragment
import com.sablab.domvetdoctor.ui.registration.passportphoto.PassportPhotoFragment
import com.sablab.domvetdoctor.ui.registration.personalinfo.PersonalInfoFragment
import com.sablab.domvetdoctor.ui.registration.selectcity.SelectCityFragment
import javax.inject.Inject

@RegistrationScope
class RegistrationFragmentFactory @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            AddYourPhotoFragment::class.java.name -> {
                AddYourPhotoFragment(viewModelFactory)
            }
            DocsAndCertificatesFragment::class.java.name -> {
                DocsAndCertificatesFragment(viewModelFactory)
            }
            PassportPhotoFragment::class.java.name -> {
                PassportPhotoFragment(viewModelFactory)
            }
            SelectCityFragment::class.java.name -> {
                SelectCityFragment(viewModelFactory)
            }
            else -> {
                PersonalInfoFragment(viewModelFactory)

            }
        }


}