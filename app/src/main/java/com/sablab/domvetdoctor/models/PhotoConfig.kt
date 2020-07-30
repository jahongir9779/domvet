package com.sablab.domvetdoctor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PhotoConfig(val imageSize: Int, val thumbnailImageSize: Int) : Parcelable {
    companion object {
        val DEFAULT = PhotoConfig(imageSize = 1024, thumbnailImageSize = 720)
    }
}