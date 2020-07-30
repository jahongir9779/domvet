package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

/*
*  "doctor_id": 1,
            "doctor": "1 1 1",
            "avatar": "http://domvet.sab-lab.com/uploads/doctor/avatars/1590213256.png",
            "created_at": "2020-07-28 04:35:57",
            "to": 1,
            "to_type": "doctor2consumer",
            "read": null,
            "message": "consumergasssa111",
            "unread_count": 0*/
data class ChatPerson(
    @SerializedName("doctor_id") val doctorId: String? = "",
    @SerializedName("doctor") val doctorName: String? = "",
    @SerializedName("avatar") val doctorAvatar: String? = "",
    @SerializedName("created_at") val lastActiveTime: String? = "",
    @SerializedName("last_message") val lastMessage: String? = "",
    @SerializedName("unread_count") val newMessageCount: String? = ""
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ChatPerson>() {
            override fun areItemsTheSame(oldItem: ChatPerson, newItem: ChatPerson): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ChatPerson, newItem: ChatPerson): Boolean =
                oldItem.doctorId == newItem.doctorId &&
                        oldItem.newMessageCount == newItem.newMessageCount

        }
    }
}