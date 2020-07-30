package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("id") val id: String? = "",
    @SerializedName("consumer_name") val consumerName: String? = "",
    @SerializedName("consumer_avatar") val consumerImage: String? = "",
    @SerializedName("doctor_name") val doctorName: String? = "",
    @SerializedName("rating") val rating: Float? = 0f,
    @SerializedName("created_at") val date: String? = "",
    @SerializedName("message") val comment: String? = ""
) {
    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<Review>() {
            override fun areItemsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Review, newItem: Review) =
                oldItem.id == newItem.id

        }
    }
}