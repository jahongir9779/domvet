package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Ignore
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.cache.db.entries.EAnimalType.Companion.COLUMN_ANIMAL_TYPE_ID
import com.sablab.domvetdoctor.cache.db.entries.EAnimalType.Companion.COLUMN_ANIMAL_TYPE_NAME

@Parcelize
data class AnimalType(
    @ColumnInfo(name = COLUMN_ANIMAL_TYPE_ID) val id: String,
    @ColumnInfo(name = COLUMN_ANIMAL_TYPE_NAME) val name: String,
    /** this is for adapter */
    @Ignore var isChecked: Boolean = false
) : Parcelable {
    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<AnimalType>() {
            override fun areItemsTheSame(oldItem: AnimalType, newItem: AnimalType) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: AnimalType, newItem: AnimalType) =
                oldItem.id == newItem.id
        }
    }
}