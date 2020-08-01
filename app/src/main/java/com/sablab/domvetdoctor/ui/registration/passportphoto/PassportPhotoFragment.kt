package com.sablab.domvetdoctor.ui.registration.passportphoto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class PassportPhotoFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_passport_photo) {

    private val viewModel: PassportPhotoViewModel by viewModels {
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

//        login.isEnabled = true
//        login.setOnClickListener {
//            navController.navigate(R.id.action_navLoginFragment_to_navPhoneFragment)
//        }
    }

    override fun onResume() {
        super.onResume()
    }


}




