package com.sablab.domvetdoctor.ui.registration.selectcity

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.ui.selectcity.SelectCityActivity
import com.sablab.domvetdoctor.ui.selectcity.SelectCityActivity.Companion.CITY_ACTIVITY_RESULT
import com.sablab.domvetdoctor.util.updateNextButtonState
import kotlinx.android.synthetic.main.fragment_select_city.*
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class SelectCityFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_select_city) {

    private val fragViewModel: SelectCityFragViewModel by viewModels {
        viewModelFactory
    }

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragViewModel.cancelActiveJobs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        navController = findNavController()

        subscribeObservers()
        attachListeners()
    }

    private fun subscribeObservers() {
        fragViewModel.selected_city.observe(viewLifecycleOwner, Observer {
            btn_next.updateNextButtonState(it != null)
            tvCity.text = it!!.cityName

        })

    }

    private fun attachListeners() {

//        login.isEnabled = true
        cardCity.setOnClickListener {

            val intent = Intent(activity, SelectCityActivity::class.java)
            startActivityForResult(intent, CITY_ACTIVITY_RESULT)
        }

        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navSelectCityFragment_to_navAddYourPhotoFragment)
        }


    }

    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(20)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            if (requestCode == CITY_ACTIVITY_RESULT) {
                fragViewModel.citySelected(data!!.getParcelableExtra(City.CITY))
            }
        } else {

        }

    }

    private fun citySelected(city: City?) {

    }
}




