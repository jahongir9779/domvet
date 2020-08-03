package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.sablab.domvetdoctor.cache.db.entries.EPhoto

data class Photo(
    @ColumnInfo(name = EPhoto.COLUMN_ID) @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = EPhoto.COLUMN_SHA) val sha: String,
    @ColumnInfo(
        name = EPhoto.COLUMN_THUMBNIAL_IMAGE,
        typeAffinity = ColumnInfo.BLOB
    ) val thumbnailImage: ByteArray,
    @ColumnInfo(name = EPhoto.COLUMN_ORGINAL_IMAGE, typeAffinity = ColumnInfo.BLOB) val image: ByteArray,
    @ColumnInfo(name = EPhoto.COLUMN_STATE) val state: Int
) {

    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo) =
                oldItem.sha == newItem.sha
        }
    }
}