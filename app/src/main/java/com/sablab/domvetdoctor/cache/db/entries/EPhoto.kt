package com.sablab.domvetdoctor.cache.db.entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = EPhoto.TABLE_NAME,
    indices = [Index(
        EPhoto.COLUMN_SHA,
        name = EPhoto.INDEX_BOX_TYPE_I1,
        unique = true
    )]
)
data class EPhoto(
    @ColumnInfo(name = COLUMN_ID) @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = COLUMN_SHA) val sha: String,
    @ColumnInfo(
        name = COLUMN_THUMBNIAL_IMAGE,
        typeAffinity = ColumnInfo.BLOB
    ) val thumbnailImage: ByteArray,
    @ColumnInfo(name = COLUMN_ORGINAL_IMAGE, typeAffinity = ColumnInfo.BLOB) val image: ByteArray,
    @ColumnInfo(name = COLUMN_STATE) val state: Int
) {

    companion object {

        const val TABLE_NAME = "e_picture"

        const val NOT_SAVED = 1
        const val SAVED = 2
        const val READY = 3
        const val LOCKED = 4

        // COLUMN NAMES
        const val COLUMN_ID = "id"
        const val COLUMN_SHA = "sha"
        const val COLUMN_THUMBNIAL_IMAGE = "thumb_image"
        const val COLUMN_ORGINAL_IMAGE = "image"
        const val COLUMN_STATE = "state"

        // TABLE INDEX
        const val INDEX_BOX_TYPE_I1 = "${TABLE_NAME}_u1"
    }

}