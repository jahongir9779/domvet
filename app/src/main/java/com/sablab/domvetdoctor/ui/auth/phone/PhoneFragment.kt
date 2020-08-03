package com.sablab.domvetdoctor.ui.auth.phone

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.util.exhaustive
import kotlinx.android.synthetic.main.fragment_phone.*
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class PhoneFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_phone) {

    private val viewModel: PhoneViewModel by viewModels {
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

        val terms = "Нажимая кнопку \"Далее\" я принимаю\n" +
                "<u>Пользовательское соглашение</u>"


        tvTerms.text = Html.fromHtml(terms)

        setupObservers()
        setupListeners()

        navController = findNavController()

        btn_next.isEnabled = true

    }

    private fun setupListeners() {
        btn_next.setOnClickListener {
            viewModel.login(phone.text.toString())
        }

        tvTerms.setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun setupObservers() {
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
//                    login.revertAnimation()
                    if (response.code == -1) {
//                        val action =
//                            PhoneFragmentDirections.actionNavPhoneFragmentToNavPhoneConfirmFragment(
//                                "",
//                                viewModel.phoneNum)
//                        findNavController().navigate(action)
                    } else if (response.code == Constants.errPhoneFormat) {
                        phone.error = getString(R.string.incorrect_phone_number_format)
//                        errorMessage.visibility = View.VISIBLE
//                        errorMessage.text = response.message
                    } else {
//                        errorMessage.visibility = View.VISIBLE
//                        errorMessage.text = response.message
                    }
                }
                is ErrorWrapper.SystemError -> {
//                    errorMessage.visibility = View.VISIBLE
//                    errorMessage.text = response.err.localizedMessage
//                    login.revertAnimation()
                }
                is ResultWrapper.Success -> {
//                    login.revertAnimation()
//                    val action =
//                        PhoneFragmentDirections.actionNavPhoneFragmentToNavPhoneConfirmFragment(
//                            response.value,
//                            viewModel.phoneNum)
//                    findNavController().navigate(action)
                }
                ResultWrapper.InProgress -> {
//                    errorMessage.visibility = View.INVISIBLE
//                    login.startAnimation()
                }
            }.exhaustive

        })
    }


}




