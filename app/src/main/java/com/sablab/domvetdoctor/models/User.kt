package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.sablab.domvetdoctor.cache.db.entries.EUser
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @ColumnInfo(name = EUser.COLUMN_USER_PHONE) val phoneNumber: String,
    @ColumnInfo(name = EUser.COLUMN_USER_TOKEN) val token: String,
    @ColumnInfo(name = EUser.COLUMN_USER_STATUS) var status: String,
    @ColumnInfo(name = EUser.COLUMN_USER_CREATED_AT) var createdAt: String,
    @ColumnInfo(name = EUser.COLUMN_USER_ID) var id: String,
    @ColumnInfo(name = EUser.COLUMN_USER_AVATAR) var avatar: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_BIRTH_DATE) var birthDate: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_FIRST_NAME) var firstName: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_MIDDLE_NAME) var middleName: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_LAST_NAME) var lastName: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_EDUCATION ) var education: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_PASSPORT) var passport: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_PASSWORD_REGISTRATION) var passportRegistration: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_EMAIL) var email: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_REGION_ID) var regionId: String? = "",
    @ColumnInfo(name = EUser.COLUMN_USER_CITY_ID) val cityId: String? = ""
) : Parcelable