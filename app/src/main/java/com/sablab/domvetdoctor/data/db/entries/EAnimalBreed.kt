package com.sablab.domvetdoctor.data.db.entries

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
        tableName = EAnimalBreed.TABLE_NAME,
        primaryKeys = [EAnimalBreed.COLUMN_ANIMAL_BREED_ID]
)
data class EAnimalBreed(
        @ColumnInfo(name = COLUMN_ANIMAL_BREED_ID) val id: String,
        @ColumnInfo(name = COLUMN_ANIMAL_BREED_NAME) val name: String
) {

    companion object {
        const val COLUMN_ANIMAL_BREED_ID = "animal_reed_id"
        const val COLUMN_ANIMAL_BREED_NAME = "animal_reed_name"

        const val TABLE_NAME = "e_animal_breed"
    }
}