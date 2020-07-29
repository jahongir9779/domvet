package com.anymobile.domvet.fragments

//import com.codingwithmitch.openapi.di.main.MainScope
//import com.codingwithmitch.openapi.ui.main.account.AccountFragment
//import com.codingwithmitch.openapi.ui.main.account.ChangePasswordFragment
//import com.codingwithmitch.openapi.ui.main.account.UpdateAccountFragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.anymobile.domvet.di.auth.AuthScope
import com.anymobile.domvet.ui.auth.confirm.PhoneConfirmFragment
import com.anymobile.domvet.ui.auth.login.LoginFragment
import com.anymobile.domvet.ui.auth.phone.PhoneFragment
import javax.inject.Inject

@AuthScope
class AuthFragmentFactory @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            LoginFragment::class.java.name -> {
                LoginFragment(viewModelFactory)
            }
            PhoneFragment::class.java.name -> {
                PhoneFragment(viewModelFactory)
            }
            PhoneConfirmFragment::class.java.name -> {
                PhoneConfirmFragment(viewModelFactory)
            }
            else -> {
                LoginFragment(viewModelFactory)
            }
        }


}