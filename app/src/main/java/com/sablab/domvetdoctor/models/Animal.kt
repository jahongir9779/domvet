package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.cache.db.entries.EAnimal
import com.sablab.domvetdoctor.models.network.NAnimal

@Parcelize
data class Animal(
    val id: String,
    val name: String,
    val weight: String,
    val age: String,
    val month: String,
    val gender: String,
    val photo: String,
    val type_animal_id: String,
    val type_animal_name: String,
    val animal_breed_id: String,
    val animal_breed_name: String,
    //this is for selected list
    var isSelected: Boolean = false
) : Parcelable {
    companion object {

        const val ANIMAL_MALE = "1"
        const val ANIMAL_FEMALE = "2"

        val DIFF_UTILL = object : DiffUtil.ItemCallback<Animal>() {
            override fun areItemsTheSame(oldItem: Animal, newItem: Animal) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Animal, newItem: Animal) =
                oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.isSelected == newItem.isSelected
        }

        fun makeObject(obj: NAnimal) = Animal(
            name = obj.name ?: "",
            id = obj.id ?: "",
            age = obj.age ?: "",
            animal_breed_id = obj.animal_breed_id ?: "",
            gender = obj.gender ?: "",
            month = obj.month ?: "",
            photo = obj.photo ?: "",
            type_animal_id = obj.type_animal_id ?: "",
            weight = obj.weight ?: "",
            animal_breed_name = obj.animal_breed_name ?: "",
            type_animal_name = obj.type_animal_name ?: ""
        )

        fun makeObject(obj: EAnimal) = Animal(
            name = obj.animalName,
            id = obj.animalId,
            age = obj.age,
            animal_breed_id = obj.animal_breed_id,
            gender = obj.gender,
            photo = obj.photo,
            month = obj.month,
            type_animal_id = obj.type_animal_id,
            weight = obj.weight,
            animal_breed_name = obj.animal_breed_name,
            type_animal_name = obj.type_animal_name
        )
    }
}