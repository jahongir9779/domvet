package com.sablab.domvetdoctor.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.util.SizeUtils.dpToPx


/**
 * Created by jahon on 05-Aug-20
 */

const val MONDAY = "monday"
const val TUESDAY = "tuesday"
const val WEDNESDAY = "wednesday"
const val THURSDAY = "thursday"
const val FRIDAY = "friday"
const val SATURDAY = "saturday"
const val SUNDAY = "sunday"


class ScheduleView(ctx: Context, attrs: AttributeSet) : HorizontalScrollView(ctx, attrs) {

    val weekdays = listOf(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY)
    val squareSize = 35

    val weekDaysMap = hashMapOf<String, ArrayList<Int>>(
        Pair(MONDAY, arrayListOf()),
        Pair(TUESDAY, arrayListOf()),
        Pair(WEDNESDAY, arrayListOf()),
        Pair(THURSDAY, arrayListOf()),
        Pair(FRIDAY, arrayListOf()),
        Pair(SATURDAY, arrayListOf()),
        Pair(SUNDAY, arrayListOf()))


    init {
        val linearLayout = LinearLayout(context)
        linearLayout.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, MATCH_PARENT)
        addView(linearLayout)
        val gridContainer = View.inflate(context, R.layout.compound_schedule_weekdays, linearLayout)
        val params = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        params.marginEnd = dpToPx(context, 20).toInt()
        gridContainer.layoutParams = params
        populateColumns(gridContainer.findViewById(R.id.hoursGrid))


    }

    private fun populateColumns(grid: GridLayout) {
        for (i in 0 until 8) {
            for (j in 8 until 23) {
                if (i == 0) {
                    val view = View.inflate(context, R.layout.schedule_hour, null) as TextView
                    val params = GridLayout.LayoutParams()
                    params.height = dpToPx(context, squareSize).toInt()
                    params.width = dpToPx(context, squareSize).toInt()
                    val margin = dpToPx(context, 5).toInt()
                    params.setMargins(margin, margin, margin, margin)
                    view.layoutParams = params
                    view.text = j.toString()
                    grid.addView(view)
                } else {
                    val view = View.inflate(context, R.layout.schedule_checkbox, null) as CheckBox
                    val params = GridLayout.LayoutParams()
                    params.height = dpToPx(context, squareSize).toInt()
                    params.width = dpToPx(context, squareSize).toInt()
                    val margin = dpToPx(context, 5).toInt()
                    params.setMargins(margin, margin, margin, margin)
                    view.layoutParams = params
                    view.setOnCheckedChangeListener { buttonView, isChecked ->
                        if (isChecked) weekDaysMap[weekdays[i - 1]]!!.add(j)
                        else weekDaysMap[weekdays[i - 1]]!!.remove(j)

                        Log.wtf("TAG", weekDaysMap.toString())
                    }
                    grid.addView(view)
                }


//            setupCheckBoxes(view, R.id.cbMonday, i, MONDAY)
//            setupCheckBoxes(view, R.id.cbTuesday, i, TUESDAY)
//            setupCheckBoxes(view, R.id.cbWednesday, i, WEDNESDAY)
//            setupCheckBoxes(view, R.id.cbThursday, i, THURSDAY)
//            setupCheckBoxes(view, R.id.cbFriday, i, FRIDAY)
//            setupCheckBoxes(view, R.id.cbSaturday, i, SATURDAY)
//            setupCheckBoxes(view, R.id.cbSunday, i, SUNDAY)

//                parentView.addView(view)
            }
        }


    }

//    private fun setupCheckBoxes(view: View, id: Int, i: Int, weekday: String) {
//        view.findViewById<CheckBox>(id).setOnClickListener {
//            Log.wtf("CLIIIICK ", "CLICK")
//
//        }
//
//
//        view.findViewById<CheckBox>(id)
//            .setOnCheckedChangeListener { buttonView, isChecked ->
//                if (isChecked) weekDaysMap[weekday]!!.add(i)
//                else weekDaysMap[weekday]!!.remove(i)
//
//                Log.wtf("TAG", weekDaysMap.toString())
//            }
//    }


}

//class ColorOptionsView(context: Context,
//                       attrs: AttributeSet?) :
//    View(context, attrs) {
//    private val mValue: View? = null
//    private val mImage: ImageView? = null
//
//    init {
//        val a = context.obtainStyledAttributes(attrs,
//                                               R.styleable.Options, 0, 0)
//        val titleText = a.getString(R.styleable.Options_titleText)
//        val valueColor = a.getColor(R.styleable.Options_valueColor,
//                                    R.color.holo_blue_light)
//        a.recycle()
//
//        // more stuff
//    }
//}