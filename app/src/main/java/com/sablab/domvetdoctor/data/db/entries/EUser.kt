package com.sablab.domvetdoctor.data.db.entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.sablab.domvetdoctor.models.User
import com.sablab.domvetdoctor.models.network.NUser

@Entity(
    tableName = EUser.TABLE_NAME,
    primaryKeys = [EUser.COLUMN_USER_PHONE]
)
class EUser(
    @ColumnInfo(name = COLUMN_USER_PHONE) val phoneNumber: String,
    @ColumnInfo(name = COLUMN_USER_TOKEN) val token: String,
    @ColumnInfo(name = COLUMN_USER_STATUS) var status: String,
    @ColumnInfo(name = COLUMN_USER_CREATED_AT) var createdAt: String,
    @ColumnInfo(name = COLUMN_USER_ID) var id: String,
    @ColumnInfo(name = COLUMN_USER_AVATAR) var avatar: String? = "",
    @ColumnInfo(name = COLUMN_USER_BIRTH_DATE) var birthDate: String? = "",
    @ColumnInfo(name = COLUMN_USER_FIRST_NAME) var firstName: String? = "",
    @ColumnInfo(name = COLUMN_USER_MIDDLE_NAME) var middleName: String? = "",
    @ColumnInfo(name = COLUMN_USER_LAST_NAME) var lastName: String? = "",
    @ColumnInfo(name = COLUMN_USER_PASSPORT) var passport: String? = "",
    @ColumnInfo(name = COLUMN_USER_PASSWORD_REGISTRATION) var passportRegistration: String? = "",
    @ColumnInfo(name = COLUMN_USER_EMAIL) var email: String? = "",
    @ColumnInfo(name = COLUMN_USER_REGION_ID) var regionId: String? = "",
    @ColumnInfo(name = COLUMN_USER_CITY_ID) val cityId: String? = "",
    @ColumnInfo(name = COLUMN_USER_LOCAL_STATE) var localState: String = USER_STATE_ACTIVE
) {

    companion object {
        const val COLUMN_USER_PHONE = "user_phone"
        const val COLUMN_USER_NAME = "user_name"
        const val COLUMN_USER_CITY_ID = "user_city_id"
        const val COLUMN_USER_REGION_ID = "user_region_id"
        const val COLUMN_USER_TOKEN = "user_token"
        const val COLUMN_USER_STATUS = "user_status"
        const val COLUMN_USER_CREATED_AT = "user_created_t"
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_USER_AVATAR = "user_avatar"
        const val COLUMN_USER_BIRTH_DATE = "user_birth_date"
        const val COLUMN_USER_FIRST_NAME = "user_first_name"
        const val COLUMN_USER_MIDDLE_NAME = "user_middle_name"
        const val COLUMN_USER_LAST_NAME = "user_last_name"
        const val COLUMN_USER_PASSPORT = "user_passport"
        const val COLUMN_USER_PASSWORD_REGISTRATION = "user_passport_registration"
        const val COLUMN_USER_EMAIL = "user_email"
        const val COLUMN_USER_LOCAL_STATE = "user_local_state"

        const val USER_STATE_ACTIVE = "A"
        const val USER_STATE_PASSIVE = "P"
        const val TABLE_NAME = "e_user"

        fun makeEUser(nUser: NUser): EUser {
            return EUser(
                phoneNumber = nUser.phoneNumber,
                regionId = nUser.regionId,
                status = nUser.status,
                cityId = nUser.cityId,
                avatar = nUser.avatar,
                birthDate = nUser.birthDate,
                createdAt = nUser.createdAt,
                email = nUser.email,
                firstName = nUser.firstName,
                id = nUser.id,
                lastName = nUser.lastName,
                middleName = nUser.middleName,
                passport = nUser.passport,
                passportRegistration = nUser.passportRegistration,
                token = nUser.token
            )
        }

        fun makeEUser(user: User) = EUser(
            phoneNumber = user.phoneNumber,
            regionId = user.regionId,
            cityId = user.cityId,
            status = user.status,
            avatar = user.avatar,
            birthDate = user.birthDate,
            createdAt = user.createdAt,
            email = user.email,
            firstName = user.firstName,
            id = user.id,
            lastName = user.lastName,
            middleName = user.middleName,
            passport = user.passport,
            passportRegistration = user.passportRegistration,
            token = user.token
        )
    }
}