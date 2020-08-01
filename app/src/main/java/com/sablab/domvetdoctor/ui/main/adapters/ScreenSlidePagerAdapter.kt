package com.sablab.domvetdoctor.ui.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(activity: FragmentActivity,
                              var activeFrag: Fragment,
                              var doneFrag: Fragment) :
    FragmentStateAdapter(activity) {

    lateinit var currentFrag: Fragment


    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        currentFrag = when (position) {
            0 -> activeFrag
            else -> doneFrag
        }
        return currentFrag
    }

}
