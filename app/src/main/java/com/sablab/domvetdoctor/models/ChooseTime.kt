package com.sablab.domvetdoctor.models

import android.os.Parcelable
import com.sablab.domvetdoctor.custom.Time
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime

@Parcelize
data class ChooseTime(
    var date: DateTime,
    var time: Time
) : Parcelable