package com.sablab.domvetdoctor.ui.registration.addyourphoto

import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.ui.BaseViewModel
import javax.inject.Inject


class AddYourPhotoViewModel @Inject constructor() : BaseViewModel() {

    private val _imageBitmap = MutableLiveData<Bitmap?>()
    val imageBitmap: LiveData<Bitmap?> get() = _imageBitmap

    fun setImageUri(imageUri: Uri?) {
        try {
            if (imageUri != null) {
                val bitmap = MediaStore.Images.Media.getBitmap(
                    App.getAppContext()?.contentResolver,
                    imageUri
                )
                _imageBitmap.value = bitmap
            }
        } catch (e: Exception) {
        }
    }


    fun setImageBitmap(image: Bitmap?) {
        _imageBitmap.value = image
    }

}
