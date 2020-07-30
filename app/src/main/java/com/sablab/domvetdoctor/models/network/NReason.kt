package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NReason(
    @SerializedName("id") val reasonId: String? = "",
    @SerializedName("name") var reasonName: String? = "",
    var isChecked: Boolean = false
) : Parcelable {
    companion object {

        val REASON_OTHER = NReason("_other", "_other")
        val DIFF_UTILL = object : DiffUtil.ItemCallback<NReason>() {
            override fun areItemsTheSame(oldItem: NReason, newItem: NReason): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: NReason, newItem: NReason): Boolean =
                oldItem.reasonId == newItem.reasonId &&
                        oldItem.isChecked == newItem.isChecked

        }
    }
}