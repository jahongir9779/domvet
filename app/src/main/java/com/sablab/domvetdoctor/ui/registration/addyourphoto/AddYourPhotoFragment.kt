package com.sablab.domvetdoctor.ui.registration.addyourphoto

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.commons.Dialog
import com.sablab.domvetdoctor.ui.photoexample.PhotoExampleActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.util.showMessageDialog
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        intiViews()
//        intiObjects()
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
            openCameraOrStorageDialog()
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


    private fun openCameraOrStorageDialog() {
        Dialog.bottomSheetDialog()
            .option(
                title = R.string.camera,
                avatar = R.drawable.ic_camera_selever_24,
                textColor = R.color.black,
                selectAction = {
                    openCamera()
                })
            .option(
                title = R.string.gallery,
                avatar = R.drawable.ic_image_24,
                textColor = R.color.black,
                selectAction = {
                    choseFile()
                })
            .show(activity)
    }

    fun openCamera() {
        checkPermissionAndRequest(
            {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                    activity?.packageManager?.let {
                        takePictureIntent.resolveActivity(it)?.also {
                            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                        }
                    }
                }
            },
            {
                activity?.showMessageDialog(R.string.warning, R.string.you_need_all_permission)
            },
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }
    fun choseFile() {
        Intent(Intent.ACTION_PICK).also {
            it.type = "image/*"
            val mimeType = arrayOf("image/jpeg", "image/png")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeType)
            startActivityForResult(it, REQUEST_GALLERY)
        }
    }
    private val REQUEST_GALLERY = 1006
    private val REQUEST_IMAGE_CAPTURE = 108


    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(40)
    }
    private val PERMISSION_REQUEST = 1111
    private var permissionGrantedAction: (() -> Unit)? = null
    private var permissionFailed: (() -> Unit)? = null
    private var permissionsList: Array<out String>? = emptyArray()
    private fun checkPermissionAndRequest(
        function: () -> Unit,
        fail: () -> Unit,
        vararg list: String
    ) {
        if (list.isNotEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                list.forEach {
                    if (activity?.let { it1 -> ContextCompat.checkSelfPermission(it1, it) }
                        != PackageManager.PERMISSION_GRANTED
                    ) {
                        permissionGrantedAction = function
                        permissionFailed = fail
                        permissionsList = list
                        requestPermissions(list, PERMISSION_REQUEST)
                        return
                    }
                }
                function.invoke()
            } else {
                function.invoke()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_GALLERY -> {
                    viewModel.setImageUri(data?.data)
//                    initViews()
                }
                REQUEST_IMAGE_CAPTURE -> {
                    val bitmapImg = data?.extras!!.get("data") as Bitmap
                    viewModel.setImageBitmap(bitmapImg)
                }
            }
        }
    }
}




