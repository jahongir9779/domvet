package com.sablab.domvetdoctor.data.db.entries

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
        tableName = EAnimalType.TABLE_NAME,
        primaryKeys = [EAnimalType.COLUMN_ANIMAL_TYPE_ID]
)
data class EAnimalType(
        @ColumnInfo(name = COLUMN_ANIMAL_TYPE_ID) var id: String,
        @ColumnInfo(name = COLUMN_ANIMAL_TYPE_NAME) var name: String
) {

    companion object {
        const val COLUMN_ANIMAL_TYPE_ID = "animal_type_id"
        const val COLUMN_ANIMAL_TYPE_NAME = "animal_type_name"

        const val TABLE_NAME = "e_animal_type"
    }
}