package com.anymobile.domvet.ui.auth.phone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.anymobile.domvet.R
import com.anymobile.domvet.ui.auth.AuthActivity
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ErrorWrapper
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.util.exhaustive
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

        setupObservers()

        /*    phone.addTextChangedListener(PhoneNumberFormattingTextWatcher())

            phone.afterTextChanged {
                viewModel.loginDataChanged(
                    phone.text.toString()
    //                password.text.toString()
                )
            }

            password.apply {
                afterTextChanged {
                    viewModel.loginDataChanged(
                        phone.text.toString(),
                        password.text.toString()
                    )
                }

                setOnEditorActionListener { _, actionId, _ ->
                    when (actionId) {
                        EditorInfo.IME_ACTION_DONE ->
                            viewModel.login(
                                phone.text.toString(),
                                password.text.toString()
                            )
                    }
                    false
                }

                login.setOnClickListener {
                    viewModel.login(phone.text.toString(), password.text.toString())
                }
            }
    */

        navController = findNavController()

        login.isEnabled = true
        login.setOnClickListener {
            viewModel.login(phone.text.toString())
//            navController.navigate(R.id.action_navLoginFragment_to_navRegisterFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AuthActivity).hideActionBar()
    }

    private fun setupObservers() {
//        viewModel.loginFormState.observe(viewLifecycleOwner, Observer {
//            val loginState = it ?: return@Observer
//            if (loginState.phoneError != null) {
//                phone.error = getString(loginState.phoneError)
//            }
//
//        })

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
                    login.revertAnimation()
                    if (response.code == -1) {
                        val action =
                            PhoneFragmentDirections.actionNavPhoneFragmentToNavPhoneConfirmFragment(
                                "",
                                viewModel.phoneNum)
                        findNavController().navigate(action)
                    } else if (response.code == Constants.errPhoneFormat) {
                        phone.error = getString(R.string.incorrect_phone_number_format)
//                        errorMessage.visibility = View.VISIBLE
//                        errorMessage.text = response.message
                    } else {
                        errorMessage.visibility = View.VISIBLE
                        errorMessage.text = response.message
                    }
                }
                is ErrorWrapper.SystemError -> {
                    errorMessage.visibility = View.VISIBLE
                    errorMessage.text = response.err.localizedMessage
                    login.revertAnimation()
                }
                is ResultWrapper.Success -> {
                    login.revertAnimation()
                    val action =
                        PhoneFragmentDirections.actionNavPhoneFragmentToNavPhoneConfirmFragment(
                            response.value,
                            viewModel.phoneNum)
                    findNavController().navigate(action)
                }
                ResultWrapper.InProgress -> {
                    errorMessage.visibility = View.INVISIBLE
                    login.startAnimation()
                }
            }.exhaustive

        })
    }


}




