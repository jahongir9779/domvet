package com.sablab.domvetdoctor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class ServiceWithPrice(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("group_id") val group_id: String? = null,
    @SerializedName("averagePrice") val averagePrice: BigDecimal? = BigDecimal.ZERO,
    var isChecked: Boolean = false
) : Parcelable {
    companion object {
        const val SERVICE_WITH_PRICE_VISIT = "SERVICE_WITH_PRICE_VISIT"

        val DIFF_UTIL = object : DiffUtil.ItemCallback<ServiceWithPrice>() {
            override fun areItemsTheSame(
                oldItem: ServiceWithPrice,
                newItem: ServiceWithPrice
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: ServiceWithPrice,
                newItem: ServiceWithPrice
            ): Boolean = oldItem.id == newItem.id

        }

        const val SERVICE_WITH_PRICE_HEADER = "SERVICE_WITH_PRICE_HEADER"

        fun makeHeaderAndItemList(list: List<ServiceWithPriceGroup>): List<ServiceWithPrice> {
            val result = mutableListOf<ServiceWithPrice>()
            val sortedList = list.sortedBy { it.name }
            sortedList.forEach {
                result.add(
                    ServiceWithPrice(
                        id = SERVICE_WITH_PRICE_HEADER,
                        name = it.name,
                        group_id = it.id
                    )
                )
                result.addAll(it.services ?: emptyList())
            }
            return result
        }

        fun makeHeaderAndItems(list: List<ServiceWithPrice>): List<ServiceWithPrice> {
            val result = mutableListOf<ServiceWithPrice>()
            val headers = list.filter { it.id == SERVICE_WITH_PRICE_HEADER }.toSet()

            val sortedHeaders = headers.sortedBy { it.name }

            for (header in sortedHeaders) {
                val groupId = header.group_id
                result.add(
                    ServiceWithPrice(
                        id = SERVICE_WITH_PRICE_HEADER,
                        name = header.name,
                        group_id = groupId
                    )
                )
                result.addAll(list.filter { it.group_id == groupId })
            }
            return result
        }
    }
}
