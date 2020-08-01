package com.sablab.domvetdoctor.ui.auth.confirm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.domain.model.AuthBody
import com.sablab.domvetdoctor.models.network.NUser
import com.sablab.domvetdoctor.ui.main.MainActivity
import com.sablab.domvetdoctor.util.*
import kotlinx.android.synthetic.main.fragment_phone_confirm.*
import splitties.activities.start
import splitties.experimental.ExperimentalSplittiesApi
import splitties.init.appCtx
import splitties.preferences.edit
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class PhoneConfirmFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_phone_confirm) {

    private val viewModel: PhoneConfirmViewModel by viewModels {
        viewModelFactory
    }

    val args: PhoneConfirmFragmentArgs by navArgs()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()


        navController = findNavController()
        btn_next.isEnabled = true

        et_received_number.setText(args.password)

        btn_next.setOnClickListener {
            viewModel.confirm(args.phone, et_received_number.text.toString().toInt())
        }

    }

    @ExperimentalSplittiesApi
    private fun setupObservers() {
        viewModel.confirmResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
//                    btn_next.revertAnimation()
//                    if (response.code == Constants.errPhoneFormat) {
//                        code.error = getString(R.string.incorrect_phone_number_format)
////                        errorMessage.visibility = View.VISIBLE
////                        errorMessage.text = response.message
//                    } else {
//                        errorMessage.visibility = View.VISIBLE
//                        errorMessage.text = response.message
//                    }
                }
                is ErrorWrapper.SystemError -> {
//                    errorMessage.visibility = View.VISIBLE
//                    errorMessage.text = response.err.message
//                    btn_next.revertAnimation()
                }
                is ResultWrapper.Success -> {
//                    btn_next.revertAnimation()
                    saveCredentials(response)
                    context?.start<MainActivity> { }

                    (appCtx as App).releaseAuthComponent()
                }
                ResultWrapper.InProgress -> {
//                    errorMessage.visibility = View.INVISIBLE
//                    btn_next.startAnimation()
                }
            }.exhaustive

        })
    }

    @ExperimentalSplittiesApi
    private fun saveCredentials(response: ResultWrapper.Success<NUser>) {
        AppPreferences.edit {
            token = response.value.token
            status = response.value.status
            id = response.value.id
            phoneNumber = response.value.phoneNumber
            createdAt = response.value.createdAt
            passport = response.value.passport
            email = response.value.email

        }
    }


    override fun onResume() {
        super.onResume()
    }


}




