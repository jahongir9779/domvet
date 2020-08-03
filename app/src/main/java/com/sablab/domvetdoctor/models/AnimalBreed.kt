package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Ignore
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.cache.db.entries.EAnimalBreed.Companion.COLUMN_ANIMAL_BREED_ID
import com.sablab.domvetdoctor.cache.db.entries.EAnimalBreed.Companion.COLUMN_ANIMAL_BREED_NAME

@Parcelize
data class AnimalBreed(
    @ColumnInfo(name = COLUMN_ANIMAL_BREED_ID) var id: String,
    @ColumnInfo(name = COLUMN_ANIMAL_BREED_NAME) var name: String,
    @Ignore var isChecked: Boolean = false
) : Parcelable {
    companion object {
        const val ANIMAL_BREED_HEADER = "ANIMAL_BREED_HEADER"

        fun makeHeaderAndItemList(list: List<AnimalBreed>): List<AnimalBreed> {
            val gourpedList =
                list.filter { it.id != ANIMAL_BREED_HEADER }.groupBy { it.name.first() }
            val result = mutableListOf<AnimalBreed>()
            val sortedKeys = gourpedList.keys.sortedBy { it.toString() }
            sortedKeys.forEach { letters ->
                val headerName = letters.toString().toUpperCase()
                if (result.find { i -> i.name == headerName } == null)
                    result.add(
                        AnimalBreed(
                            id = ANIMAL_BREED_HEADER,
                            name = headerName
                        )
                    )
                gourpedList[letters]?.let { result.addAll(it) }
            }
            return result
        }

        val DIFF_UTILL = object : DiffUtil.ItemCallback<AnimalBreed>() {
            override fun areItemsTheSame(oldItem: AnimalBreed, newItem: AnimalBreed) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: AnimalBreed, newItem: AnimalBreed) =
                oldItem.id == newItem.id
        }
    }
}