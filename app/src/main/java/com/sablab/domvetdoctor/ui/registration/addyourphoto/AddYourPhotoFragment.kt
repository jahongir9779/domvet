package com.sablab.domvetdoctor.ui.registration.addyourphoto

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.photoexample.PhotoExampleActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationViewModel
import com.sablab.domvetdoctor.util.AVATAR
import com.sablab.domvetdoctor.util.PhotoAttachHelper
import com.sablab.domvetdoctor.util.loadCircleBitmap
import com.sablab.domvetdoctor.util.updateNextButtonState
import kotlinx.android.synthetic.main.fragment_add_your_photo.*
import splitties.fragments.start
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class AddYourPhotoFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_add_your_photo) {


    private val viewModel: AddYourPhotoViewModel by viewModels {
        viewModelFactory
    }
    private val actViewModel: RegistrationViewModel by activityViewModels()

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        parent.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        navController = findNavController()

        attachListeners()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        intiViews()
//        intiObjects()
        subscribeObservers()
    }

    private fun intiViews() {
        cardImage.setBackgroundResource(R.drawable.shape_round_stroke_white)

    }

    private fun subscribeObservers() {
        actViewModel.avatarBitmap.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                image.loadCircleBitmap(it)
                icRemove.visibility = View.VISIBLE
                icAdd.visibility = View.INVISIBLE
            } else {
                image.setImageBitmap(null)
                icRemove.visibility = View.INVISIBLE
                icAdd.visibility = View.VISIBLE
            }
            btn_next.updateNextButtonState(it != null)
        })
    }


    private fun attachListeners() {

//        login.isEnabled = true
        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navAddYourPhotoFragment_to_navPassportAndPhotoFragment)
        }

        cardPhotoExample.setOnClickListener {
            start<PhotoExampleActivity> { }
        }

        image.setOnClickListener {
            PhotoAttachHelper.openCameraOrStorageDialog(requireActivity(),
                                                        AVATAR)
        }

        icRemove.setOnClickListener {
            actViewModel.setImageBitmap(null, AVATAR)
        }

//        edtSurname.doOnTextChanged { text, start, before, count ->
//            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
//        }
//        edtName.doOnTextChanged { text, start, before, count ->
//            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
//        }
//        edtFathersName.doOnTextChanged { text, start, before, count ->
//            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
//        }
//        edtDob.doOnTextChanged { text, start, before, count ->
//            btn_next.updateNextButtonState(edtName.text.isNotBlank() && edtSurname.text.isNotBlank() && edtFathersName.text.isNotBlank() && edtDob.text.isNotBlank())
//        }

    }


    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(40)
    }


}




