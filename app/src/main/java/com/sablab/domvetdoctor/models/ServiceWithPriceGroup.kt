package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class ServiceWithPriceGroup(
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("type_animal_id") val typeAnimalId: String? = "",
    @SerializedName("services") val services: List<ServiceWithPrice>? = emptyList()
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ServiceWithPriceGroup>() {
            override fun areItemsTheSame(
                oldItem: ServiceWithPriceGroup,
                newItem: ServiceWithPriceGroup
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: ServiceWithPriceGroup,
                newItem: ServiceWithPriceGroup
            ): Boolean = oldItem.id == newItem.id

        }
    }
}