package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class FAQ(
    @SerializedName("question") val question: String? = "",
    @SerializedName("answer") val answer: String? = "",
    var isExpanded: Boolean = false
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<FAQ>() {
            override fun areItemsTheSame(oldItem: FAQ, newItem: FAQ): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: FAQ, newItem: FAQ): Boolean =
                oldItem.answer == newItem.answer && oldItem.question == newItem.question

        }
    }
}