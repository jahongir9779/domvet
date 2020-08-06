package com.sablab.domvetdoctor.ui.registration.passportphoto

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
import com.sablab.domvetdoctor.ui.passportexample.PassportPhotoExampleActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationViewModel
import com.sablab.domvetdoctor.util.*
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
    private val actViewModel: RegistrationViewModel by activityViewModels()

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        intiViews()

        navController = findNavController()
//        cardImage1.setBackgroundResource(R.drawable.ic_rectangle_copy)
//        login.isEnabled = true
        attachListeners()
        subscribeObservers()
    }

    private fun intiViews() {
        cardImage1.setBackgroundResource(R.drawable.shape_portrait_photo_bg_stroke_white)
        cardImage2.setBackgroundResource(R.drawable.shape_portrait_photo_bg_stroke_white)
    }

    private fun subscribeObservers() {
        actViewModel.passportBitmap1.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                image1.loadBitmap(it)
                icRemove1.visibility = View.VISIBLE
                icAdd1.visibility = View.INVISIBLE
            } else {
                image1.setImageBitmap(null)
                icRemove1.visibility = View.INVISIBLE
                icAdd1.visibility = View.VISIBLE
            }
            btn_next.updateNextButtonState(it != null && actViewModel.passportBitmap2.value != null)
        })
        actViewModel.passportBitmap2.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                image2.loadBitmap(it)
                icRemove2.visibility = View.VISIBLE
                icAdd2.visibility = View.INVISIBLE
            } else {
                image2.setImageBitmap(null)
                icRemove2.visibility = View.INVISIBLE
                icAdd2.visibility = View.VISIBLE
            }
            btn_next.updateNextButtonState(it != null && actViewModel.passportBitmap1.value != null)
        })

    }

    private fun attachListeners() {
        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navPassportAndPhotoFragment_to_navDocsAndCertificatesFragment)
        }

        cardPhotoExample.setOnClickListener {
            start<PassportPhotoExampleActivity> { }
        }
        image1.setOnClickListener {
            PhotoAttachHelper.openCameraOrStorageDialog(requireActivity(), PASSPORT1)
        }

        image2.setOnClickListener {
            PhotoAttachHelper.openCameraOrStorageDialog(requireActivity(), PASSPORT2)
        }

        icRemove1.setOnClickListener {
            actViewModel.setImageBitmap(null, PASSPORT1)
        }
        icRemove2.setOnClickListener {
            actViewModel.setImageBitmap(null, PASSPORT2)
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(60)
    }

//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            val photoType = PhotoType.valueOf(data?.getStringExtra(PhotoType::class.java.name)!!)
//            when (requestCode) {
//                REQUEST_GALLERY -> {
//                    actViewModel.setImageUri(data.data, PhotoType.PASSPORT1)
////                    initViews()
//                }
//                REQUEST_IMAGE_CAPTURE -> {
//                    val bitmapImg = data?.extras!!.get("data") as Bitmap
//                    actViewModel.setImageBitmap(bitmapImg, photoType)
//                }
//            }
//        }
//    }


}




