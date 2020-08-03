package com.sablab.domvetdoctor.cache.db.entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.sablab.domvetdoctor.models.Animal

@Entity(
        tableName = EAnimal.TABLE_NAME,
        primaryKeys = [EAnimal.COLUMN_ANIMA_ID]
)
class EAnimal(
        @ColumnInfo(name = COLUMN_ANIMA_ID) val animalId: String,
        @ColumnInfo(name = COLUMN_ANIMA_NAME) val animalName: String,
        @ColumnInfo(name = COLUMN_ANIMA_WEIGHT) val weight: String,
        @ColumnInfo(name = COLUMN_ANIMA_AGE) val age: String,
        @ColumnInfo(name = COLUMN_ANIMA_MONTH) val month: String,
        @ColumnInfo(name = COLUMN_ANIMA_PHOTO) val photo: String,
        @ColumnInfo(name = COLUMN_ANIMA_GENDER) val gender: String,
        @ColumnInfo(name = COLUMN_ANIMA_TYPE_ANIMAL_ID) val type_animal_id: String,
        @ColumnInfo(name = COLUMN_ANIMA_TYPE_ANIMAL_NAME) val type_animal_name: String,
        @ColumnInfo(name = COLUMN_ANIMA_TYPE_BREED_ID) val animal_breed_id: String,
        @ColumnInfo(name = COLUMN_ANIMA_TYPE_BREED_NAME) val animal_breed_name: String
) {

    companion object {
        fun makeObject(it: Animal) = EAnimal(
                animalId = it.id, animalName = it.name, weight = it.weight,
                type_animal_id = it.type_animal_id,
                month = it.month,
                gender = it.gender,
                photo = it.photo,
                animal_breed_id = it.animal_breed_id,
                age = it.age,
                type_animal_name = it.type_animal_name,
                animal_breed_name = it.animal_breed_name
        )

        const val COLUMN_ANIMA_ID = "animal_id"
        const val COLUMN_ANIMA_NAME = "animal_name"
        const val COLUMN_ANIMA_WEIGHT = "animal_weight"
        const val COLUMN_ANIMA_AGE = "animal_age"
        const val COLUMN_ANIMA_MONTH = "animal_month"
        const val COLUMN_ANIMA_PHOTO = "animal_photo"
        const val COLUMN_ANIMA_GENDER = "animal_gender"
        const val COLUMN_ANIMA_TYPE_ANIMAL_ID = "animal_type_animal_id"
        const val COLUMN_ANIMA_TYPE_ANIMAL_NAME = "animal_type_animal_name"
        const val COLUMN_ANIMA_TYPE_BREED_ID = "animal_animal_breed_id"
        const val COLUMN_ANIMA_TYPE_BREED_NAME = "animal_animal_breed_name"

        const val TABLE_NAME = "e_animal"
    }
}