package com.sablab.domvetdoctor.data.db.entries

/* "id": 408261,
    "name": "Сорочинск",
    "slug": "sorochinsk",
    "country_code": "ru",
    "status": 1,
    "region_id": 781878*/

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
        tableName = ECity.TABLE_NAME,
        primaryKeys = [ECity.COLUMN_CITY_ID]
)
class ECity(
        @ColumnInfo(name = COLUMN_CITY_ID) val cityId: String,
        @ColumnInfo(name = COLUMN_CITY_NAME) val cityName: String,
        @ColumnInfo(name = COLUMN_CITY_SLUG) val citySlug: String,
        @ColumnInfo(name = COLUMN_COUNTRY_CODE) val countryCode: String,
        @ColumnInfo(name = COLUMN_STATUS) val status: String,
        @ColumnInfo(name = COLUMN_REGION_ID) val regionId: String
) {

    companion object {
        const val COLUMN_CITY_ID = "city_id"
        const val COLUMN_CITY_NAME = "city_name"
        const val COLUMN_CITY_SLUG = "city_slug"
        const val COLUMN_COUNTRY_CODE = "city_country_code"
        const val COLUMN_STATUS = "city_status"
        const val COLUMN_REGION_ID = "city_region_id"

        const val TABLE_NAME = "e_city"
    }
}