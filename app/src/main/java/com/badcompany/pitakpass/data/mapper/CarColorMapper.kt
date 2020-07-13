package com.badcompany.pitakpass.data.mapper

import com.badcompany.pitakpass.data.model.CarColorEntity
import com.badcompany.pitakpass.data.model.UserEntity
import com.badcompany.pitakpass.domain.domainmodel.CarColorBody
import com.badcompany.pitakpass.domain.domainmodel.User
import javax.inject.Inject


/**
 * Map a [UserEntity] to and from a [User] instance when data is moving between
 * this later and the Domain layer
 */
open class CarColorMapper @Inject constructor() : Mapper<CarColorEntity, CarColorBody> {

    /**
     * Map a [UserEntity] instance to a [User] instance
     */
    override fun mapFromEntity(type: CarColorEntity): CarColorBody {
        return CarColorBody(type.id, type.hex, type.nameEn, type.nameUz, type.nameRu)
    }

    /**
     * Map a [User] instance to a [UserEntity] instance
     */
    override fun mapToEntity(type: CarColorBody): CarColorEntity {
        return CarColorEntity(type.id!!, type.hex!!, type.nameEn!!, type.nameUz!!, type.nameRu!!)
    }


}