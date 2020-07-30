package com.sablab.domvetdoctor.models.network

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.data.db.entries.EAnimal
import com.sablab.domvetdoctor.models.Animal

@Parcelize
data class NAnimal(
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("photo") val photo: String? = "",
    @SerializedName("age") val age: String? = "",
    @SerializedName("weight") val weight: String? = "",
    @SerializedName("status") val status: String? = "",
    @SerializedName("month") val month: String? = "",
    @SerializedName("gender") val gender: String? = "",
    @SerializedName("animal_breed_id") val animal_breed_id: String? = "",
    @SerializedName("type_animal_id") val type_animal_id: String? = "",
    @SerializedName("type_animal_name") val type_animal_name: String? = "",
    @SerializedName("animal_breed_name") val animal_breed_name: String? = "",
    @SerializedName("consumer_id") val consumerId: String? = "",
    @SerializedName("created_at") val createdAt: String? = ""
) : Parcelable {
    companion object {

        const val ANIMAL_MALE = "1"
        const val ANIMAL_FEMALE = "2"

        val DIFF_UTILL = object : DiffUtil.ItemCallback<NAnimal>() {
            override fun areItemsTheSame(oldItem: NAnimal, newItem: NAnimal) = oldItem == newItem

            override fun areContentsTheSame(oldItem: NAnimal, newItem: NAnimal) =
                oldItem.id == newItem.id && oldItem.name == newItem.name
        }
    }
}