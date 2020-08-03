package com.sablab.domvetdoctor.ui.registration.personalinfo

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.util.updateNextButtonState
import kotlinx.android.synthetic.main.fragment_personal_info.*
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class PersonalInfoFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_personal_info) {

    private val viewModel: PersonalInfoViewModel by viewModels {
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
        attachListeners()
    }

    private fun attachListeners() {

//        login.isEnabled = true
        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navPersonalInfoFragment_to_navSelectCityFragment)
        }

        edtSurname.doOnTextChanged { text, start, before, count ->
            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
        }
        edtName.doOnTextChanged { text, start, before, count ->
            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
        }
        edtFathersName.doOnTextChanged { text, start, before, count ->
            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
        }
        edtDob.doOnTextChanged { text, start, before, count ->
            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
        }

    }


    override fun onResume() {
        super.onResume()

        (activity as RegistrationActivity).setRegProgress(0)
    }


}




