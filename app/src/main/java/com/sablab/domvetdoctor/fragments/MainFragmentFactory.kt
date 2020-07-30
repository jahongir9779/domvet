package com.sablab.domvetdoctor.fragments

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.sablab.domvetdoctor.di.main.MainScope
import com.sablab.domvetdoctor.ui.main.finance.FinanceFragment
import com.sablab.domvetdoctor.ui.main.mycalls.MyCallsFragment
import com.sablab.domvetdoctor.ui.main.profile.ProfileFragment
import com.sablab.domvetdoctor.ui.main.searchtrip.SearchTripFragment
//import com.codingwithmitch.openapi.di.main.MainScope
//import com.codingwithmitch.openapi.ui.main.account.AccountFragment
//import com.codingwithmitch.openapi.ui.main.account.ChangePasswordFragment
//import com.codingwithmitch.openapi.ui.main.account.UpdateAccountFragment
import javax.inject.Inject

@MainScope
class MainFragmentFactory @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            SearchTripFragment::class.java.name -> {
                SearchTripFragment(viewModelFactory)
            }
            MyCallsFragment::class.java.name -> {
                MyCallsFragment(viewModelFactory)
            }
            FinanceFragment::class.java.name -> {
                FinanceFragment(viewModelFactory)
            }
            ProfileFragment::class.java.name -> {
                ProfileFragment(viewModelFactory)
            }
            else -> {
                SearchTripFragment(viewModelFactory)
            }
        }


}