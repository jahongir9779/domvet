package com.sablab.domvetdoctor.ui.registration.passportphoto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.passportexample.PassportPhotoExampleActivity
import com.sablab.domvetdoctor.ui.photoexample.PhotoExampleActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.fragment_passport_photo.*
import splitties.fragments.start
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
//        cardImage1.setBackgroundResource(R.drawable.ic_rectangle_copy)
//        login.isEnabled = true
        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navPassportAndPhotoFragment_to_navDocsAndCertificatesFragment)
        }

        cardPhotoExample.setOnClickListener {
            start<PassportPhotoExampleActivity> { }
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(60)
    }


}




