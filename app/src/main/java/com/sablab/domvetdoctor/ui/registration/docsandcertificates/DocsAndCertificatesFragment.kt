package com.sablab.domvetdoctor.ui.registration.docsandcertificates

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.docsexample.DocsPhotoExampleActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_docs_and_certificates.*
import kotlinx.android.synthetic.main.fragment_docs_and_certificates.btn_next
import kotlinx.android.synthetic.main.fragment_schedule.*
import splitties.fragments.start
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class DocsAndCertificatesFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_docs_and_certificates) {


    private val activityViewModel: RegistrationViewModel by activityViewModels {
        viewModelFactory
    }

    private val viewModel: DocsAndCertificatesViewModel by viewModels {
        viewModelFactory
    }

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

//DO NOT FORGET!!!    (appCtx as App).releaseRegistrationComponent()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        navController = findNavController()

//        login.isEnabled = true
        cardDocsPhotoExample.setOnClickListener {
            start<DocsPhotoExampleActivity> { }
        }

        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navDocsAndCertificatesFragment_to_navBiographyFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(80)
    }


}




