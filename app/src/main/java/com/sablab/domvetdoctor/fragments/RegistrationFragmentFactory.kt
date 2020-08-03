package com.sablab.domvetdoctor.fragments

//import com.codingwithmitch.openapi.di.main.MainScope
//import com.codingwithmitch.openapi.ui.main.account.AccountFragment
//import com.codingwithmitch.openapi.ui.main.account.ChangePasswordFragment
//import com.codingwithmitch.openapi.ui.main.account.UpdateAccountFragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.registration.RegistrationScope
import com.sablab.domvetdoctor.ui.registration.addyourphoto.AddYourPhotoFragment
import com.sablab.domvetdoctor.ui.registration.biography.BiographyFragment
import com.sablab.domvetdoctor.ui.registration.docsandcertificates.DocsAndCertificatesFragment
import com.sablab.domvetdoctor.ui.registration.end.RegistrationEndFragment
import com.sablab.domvetdoctor.ui.registration.myregions.MyRegionsFragment
import com.sablab.domvetdoctor.ui.registration.passportphoto.PassportPhotoFragment
import com.sablab.domvetdoctor.ui.registration.personalinfo.PersonalInfoFragment
import com.sablab.domvetdoctor.ui.registration.schedule.ScheduleFragment
import com.sablab.domvetdoctor.ui.registration.selectcity.SelectCityFragment
import com.sablab.domvetdoctor.ui.registration.serviceprice.ServicePricesFragment
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
            BiographyFragment::class.java.name -> {
                BiographyFragment(viewModelFactory)
            }
            MyRegionsFragment::class.java.name -> {
                MyRegionsFragment(viewModelFactory)
            }
            ScheduleFragment::class.java.name -> {
                ScheduleFragment(viewModelFactory)
            }
            ServicePricesFragment::class.java.name -> {
                ServicePricesFragment(viewModelFactory)
            }
            RegistrationEndFragment::class.java.name -> {
                RegistrationEndFragment(viewModelFactory)
            }
            else -> {
                PersonalInfoFragment(viewModelFactory)

            }
        }


}