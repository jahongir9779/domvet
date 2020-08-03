package com.sablab.domvetdoctor.cache.db.entries

/*  "id": 781877,
    "code": "ru",
    "name": "Омская область",
    "slug": "omskaya-oblast",
    "utc": null,
    "status": 1*/

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
        tableName = ERegion.TABLE_NAME,
        primaryKeys = [ERegion.COLUMN_REGION_ID]
)
class ERegion(
        @ColumnInfo(name = COLUMN_REGION_ID) val regionId: String,
        @ColumnInfo(name = COLUMN_REGION_NAME) val regionName: String,
        @ColumnInfo(name = COLUMN_REGION_SLUG) val regionSlug: String,
        @ColumnInfo(name = COLUMN_CODE) val countryCode: String,
        @ColumnInfo(name = COLUMN_STATUS) val status: String,
        @ColumnInfo(name = COLUMN_UTC) val utc: String
) {

    companion object {
        const val COLUMN_REGION_ID = "region_id"
        const val COLUMN_REGION_NAME = "region_name"
        const val COLUMN_REGION_SLUG = "region_slug"
        const val COLUMN_CODE = "region_code"
        const val COLUMN_STATUS = "region_status"
        const val COLUMN_UTC = "region_utc"

        const val TABLE_NAME = "e_region"
    }
}