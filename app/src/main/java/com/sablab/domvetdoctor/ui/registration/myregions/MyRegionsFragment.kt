package com.sablab.domvetdoctor.ui.registration.myregions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.fragment_my_regions.*
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class MyRegionsFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_my_regions) {

    private val viewModel: MyRegionsFragViewModel by viewModels {
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
            navController.navigate(R.id.action_navMyRegionsFragment_to_navScheduleFragment)
        }
//
//        cardPhotoExample.setOnClickListener {
//            start<PassportPhotoExampleActivity> { }
//        }

    }

    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(60)
    }


}




