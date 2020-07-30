package com.sablab.domvetdoctor.models.payment

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import ru.cloudpayments.sdk.cp_card.CPCardType
import com.sablab.domvetdoctor.R

@Parcelize
data class Card(
    @SerializedName("id") val cardId: String? = "",
    @SerializedName("expire_at") val expireAt: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("number") val cardNumber: String? = "",
    @SerializedName("token") val token: String? = ""
) : Parcelable {

    fun getCardIcon() = when (CPCardType.getType(cardNumber)) {
        CPCardType.JCB -> R.drawable.ic_jcb_card
        CPCardType.MAESTRO -> R.drawable.ic_maestro_card
        CPCardType.MASTER_CARD -> R.drawable.ic_master_card
        CPCardType.MIR -> R.drawable.ic_mir_card
        CPCardType.VISA -> R.drawable.ic_visa_card
        CPCardType.UNKNOWN -> R.drawable.ic_credit_card_24_accent
        else -> R.drawable.ic_credit_card_24_accent
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
                oldItem.cardId == newItem.cardId

        }
    }

}