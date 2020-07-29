package com.anymobile.domvet.ui.auth.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.util.exhaustive
import com.anymobile.domvet.R
import com.anymobile.domvet.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class LoginFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        navController = findNavController()

        login.isEnabled = true
        login.setOnClickListener {
//            viewModel.login(phone.text.toString())
//            navController.navigate(R.id.action_navLoginFragment_to_navRegisterFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AuthActivity).hideActionBar()
    }


}




