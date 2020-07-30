package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

/*"id": 1,
            "name": "Ветеринарно-санитарный факультет Московского Государственного Университета Прикладной Биотехнологии",
            "end_date": "2020-01-01",
            "work_experience": "1.5",
            "bio": "Закончил ветеринарно-санитарный факультет Московского Государственного Университета Прикладной Биотехнологии в 2010г. Повышение квалификации по курсу \"Анестезиология мелких домашних животных\"",
            "doctor_id": 1*/
data class Bio(
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("end_date") val end_date: String? = "",
    @SerializedName("work_experience") val work_experience: String? = "",
    @SerializedName("bio") val bio: String? = "",
    @SerializedName("doctor_id") val doctor_id: String? = ""
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Bio>() {
            override fun areItemsTheSame(oldItem: Bio, newItem: Bio) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Bio, newItem: Bio) = oldItem.id == newItem.id
        }
    }
}