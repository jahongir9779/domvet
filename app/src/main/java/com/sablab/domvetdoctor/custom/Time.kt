package com.sablab.domvetdoctor.custom

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by jhonn on 28/02/2017.
 */
@Parcelize
data class Time(val time: String, val timeCode: Int, var isSelected: Boolean = false) : Parcelable {

    companion object {
        @kotlin.jvm.JvmStatic
        val times: List<Time>
            get() {
                val times: MutableList<Time> =
                    ArrayList()
                times.add(Time("00:00", 0))
                times.add(Time("01:00", 1))
                times.add(Time("02:00", 2))
                times.add(Time("03:00", 3))
                times.add(Time("04:00", 4))
                times.add(Time("05:00", 5))
                times.add(Time("06:00", 6))
                times.add(Time("07:00", 7))
                times.add(Time("08:00", 8))
                times.add(Time("09:00", 9))
                times.add(Time("10:00", 10))
                times.add(Time("11:00", 11))
                times.add(Time("12:00", 12))
                times.add(Time("13:00", 13))
                times.add(Time("14:00", 14))
                times.add(Time("15:00", 15))
                times.add(Time("16:00", 16))
                times.add(Time("17:00", 17))
                times.add(Time("18:00", 18))
                times.add(Time("19:00", 19))
                times.add(Time("20:00", 20))
                times.add(Time("21:00", 21))
                times.add(Time("22:00", 22))
                times.add(Time("23:00", 23))
                return times
            }
    }

}