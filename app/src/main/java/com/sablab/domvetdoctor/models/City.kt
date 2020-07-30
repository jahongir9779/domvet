package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize
import com.sablab.domvetdoctor.data.db.entries.ECity

@Parcelize
data class City(
    @ColumnInfo(name = ECity.COLUMN_CITY_ID) val cityId: String,
    @ColumnInfo(name = ECity.COLUMN_CITY_NAME) val cityName: String,
    @ColumnInfo(name = ECity.COLUMN_CITY_SLUG) val citySlug: String,
    @ColumnInfo(name = ECity.COLUMN_COUNTRY_CODE) val countryCode: String,
    @ColumnInfo(name = ECity.COLUMN_STATUS) val status: String,
    @ColumnInfo(name = ECity.COLUMN_REGION_ID) val regionId: String
) : Parcelable {

    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<City>() {
            override fun areItemsTheSame(oldItem: City, newItem: City) = oldItem == newItem

            override fun areContentsTheSame(oldItem: City, newItem: City) =
                oldItem.cityId == newItem.cityId
        }
    }
}