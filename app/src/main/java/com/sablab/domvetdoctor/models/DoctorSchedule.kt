package com.sablab.domvetdoctor.models

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class DoctorSchedule(
    @SerializedName("id") val id: String? = "",
    @SerializedName("doctor_id") val doctor_id: String = "",
    @SerializedName("date") val date: String = "",
    @SerializedName("week") val week: String? = ""
) {

    fun getDateNumber(): Int = try {
        val date = SimpleDateFormat("HH:mm:ss", Locale.forLanguageTag("ru")).parse(date)
        val calendar = Calendar.getInstance()
        calendar.setTime(date)
        calendar.get(Calendar.HOUR_OF_DAY)
    } catch (e: Exception) {
        -1
    }

    fun getWeekNumber(): Int = try {
        week?.toInt()?.plus(1) ?: -1
    } catch (e: Exception) {
        -1
    }

}