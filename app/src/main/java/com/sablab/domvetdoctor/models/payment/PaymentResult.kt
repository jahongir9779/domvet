package com.sablab.domvetdoctor.models.payment

import com.google.gson.annotations.SerializedName

/*
*   "transactionId": 436963354,
    "amount": 1,
    "currency": "RUB",
    "currencyCode": "RUB",
    "cardFirstSix": "RUB",
    "cardLastFour": "RUB",
    "cardExpiredMonth": "04",
    "cardExpiredYear": "2022",
    "accountId": null,
    "email": null,
    "description": null,
    "jsonData": null,
    "createdDateIso": {
        "date": "2020-07-24 17:09:05.000000",
        "timezone_type": 3,
        "timezone": "UTC"
    },
    "authDateIso": {
        "date": "2020-07-24 17:09:05.000000",
        "timezone_type": 3,
        "timezone": "UTC"
    },
    "confirmDateIso": {
        "date": "2020-07-24 18:09:05.000000",
        "timezone_type": 3,
        "timezone": "UTC"
    },
    "authCode": "A1B2C3",
    "testMode": true,
    "ipAddress": "192.168.0.100",
    "ipCountry": "",
    "ipCity": null,
    "ipRegion": null,
    "ipDistrict": null,
    "invoiceId": null,
    "ipLatitude": null,
    "ipLongitude": null,
    "cardType": "visa",
    "cardTypeCode": 0,
    "issuer": "CloudPayments",
    "issuerBankCountry": "RU",
    "status": "authorized",
    "statusCode": 2,
    "reason": "Approved",
    "reasonCode": 0,
    "cardHolderMessage": "Payment was successful",
    "name": "SHAKHZOD URINBOEV",
    "token": "9BBEF19476623CA56C17DA75FD57734DBF82530686043A6E491C6D71BEFE8F6E"
    * */
data class PaymentResult(
    @SerializedName("transactionId") val transactionId: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("token") val token: String? = null,
    @SerializedName("reason") val reason: String? = null,
    @SerializedName("reasonCode") val reasonCode: Int? = null,
    @SerializedName("cardHolderMessage") val cardHolderMessage: String? = null,

    @SerializedName("amount") val amount: String? = null,
    @SerializedName("currency") val currency: String? = null,
    @SerializedName("currencyCode") val currencyCode: String? = null,
    @SerializedName("cardFirstSix") val cardFirstSix: String? = null,
    @SerializedName("cardLastFour") val cardLastFour: String? = null,
    @SerializedName("cardExpiredMonth") val cardExpiredMonth: String? = null,
    @SerializedName("cardExpiredYear") val cardExpiredYear: String? = null,
    @SerializedName("accountId") val accountId: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("jsonData") val jsonData: String? = null,
    @SerializedName("createdDateIso") val createdDateIso: PaymentDate? = null,
    @SerializedName("authDateIso") val authDateIso: PaymentDate? = null,
    @SerializedName("confirmDateIso") val confirmDateIso: PaymentDate? = null,
    @SerializedName("authCode") val authCode: String? = null,
    @SerializedName("paymentAmount") val paymentAmount: String? = null,
    @SerializedName("paymentCurrency") val paymentCurrency: String? = null,
    @SerializedName("paymentCurrencyCode") val paymentCurrencyCode: String? = null,
    @SerializedName("testMode") val testMode: String? = null,
    @SerializedName("ipAddress") val ipAddress: String? = null,
    @SerializedName("ipCountry") val ipCountry: String? = null,
    @SerializedName("ipCity") val ipCity: String? = null,
    @SerializedName("ipRegion") val ipRegion: String? = null,
    @SerializedName("ipDistrict") val ipDistrict: String? = null,
    @SerializedName("invoiceId") val invoiceId: String? = null,
    @SerializedName("ipLatitude") val ipLatitude: String? = null,
    @SerializedName("ipLongitude") val ipLongitude: String? = null,
    @SerializedName("cardType") val cardType: String? = null,
    @SerializedName("cardTypeCode") val cardTypeCode: String? = null,
    @SerializedName("issuer") val issuer: String? = null,
    @SerializedName("issuerBankCountry") val issuerBankCountry: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("statusCode") val statusCode: String? = null,
    @SerializedName("name") val name: String? = null
) {
    companion object {
        val INCORRECT_CVC_CODES = listOf(5082, 5006, 5005, 5019)
        val INCORRECT_DATE = listOf(5054, 5033)
    }
}