package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import com.sablab.domvetdoctor.util.DateUtil

data class ChatMessage(
    @SerializedName("message") val message: String? = null,
    @SerializedName("date") val date: String? = null,
    @SerializedName("from_person_id") val from_person_id: String? = null
) {
    val isClientMessage: Boolean = from_person_id == SELF_MESSAGE
    fun getChatTime(): String {
        return if (date?.isNotEmpty() == true) {
            try {
                DateUtil.convert(date, DateUtil.HH_MM.get())
            } catch (e: Exception) {
                ""
            }
        } else {
            ""
        }
    }

    companion object {
        const val SELF_MESSAGE = "-1"
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ChatMessage>() {
            override fun areItemsTheSame(oldItem: ChatMessage, newItem: ChatMessage) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ChatMessage, newItem: ChatMessage) =
                oldItem.message == newItem.message
                        && oldItem.date == newItem.date

        }
    }
}