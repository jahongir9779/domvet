package com.anymobile.domvet.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Parcelable
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.anymobile.domvet.R
import com.anymobile.domvet.fragments.FinanceNavHostFragment
import com.anymobile.domvet.fragments.MyTripsNavHostFragment
import com.anymobile.domvet.fragments.ProfileNavHostFragment
import com.anymobile.domvet.fragments.SearchTripNavHostFragment
import com.anymobile.domvet.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.parcel.Parcelize

/**
 * Class credit: Allan Veloso
 * I took the concept from Allan Veloso and made alterations to fit our needs.
 * https://stackoverflow.com/questions/50577356/android-jetpack-navigation-bottomnavigationview-with-youtube-or-instagram-like#_=_
 * @property navigationBackStack: Backstack for the bottom navigation
 */

const val BOTTOM_NAV_BACKSTACK_KEY =
    "com.anymobile.domvet.util.BottomNavController.bottom_nav_backstack"

class BottomNavControllerFix(
    val context: Context,
    @IdRes val containerId: Int,
    @IdRes val appStartDestinationId: Int,
    val graphChangeListener: OnNavigationGraphChanged?
) {
    var fragment1 = SearchTripNavHostFragment.create(R.navigation.nav_search_trip_graph)
    var fragment2 = MyTripsNavHostFragment.create(R.navigation.nav_my_trips_graph)
    var fragment3 = FinanceNavHostFragment.create(R.navigation.nav_finance_graph)
    var fragment4 = ProfileNavHostFragment.create(R.navigation.nav_profile_graph)

    var active: Fragment? = fragment1

    private val TAG: String = "AppDebug"
    lateinit var navigationBackStack: BackStack
    lateinit var activity: Activity
    lateinit var fragmentManager: FragmentManager
    lateinit var navItemChangeListener: OnNavigationItemChanged

    init {
        if (context is Activity) {
            activity = context
            fragmentManager = (activity as FragmentActivity).supportFragmentManager
//            fragment1 = fragmentManager.findFragmentByTag(R.id.nav_menu_trade.toString())
//                ?: createNavHost(R.id.nav_menu_trade)

//            fragment2 = fragmentManager.findFragmentByTag(R.id.nav_menu_my_calls.toString())
//                ?: createNavHost(R.id.nav_menu_my_calls)

//            fragment3 = fragmentManager.findFragmentByTag(R.id.nav_menu_profile.toString())
//                ?: createNavHost(R.id.nav_menu_profile)


            val start = System.currentTimeMillis()

//            fragmentManager.beginTransaction()
//                .add(containerId, fragment4, R.id.nav_menu_profile.toString())
//                .hide(fragment4)
//                .commit()
            fragmentManager.beginTransaction()
                .add(containerId, fragment2, R.id.nav_menu_my_calls.toString())
                .hide(fragment2)
                .commit()
            fragmentManager.beginTransaction()
                .add(containerId, fragment3, R.id.nav_menu_profile.toString())
                .hide(fragment3)
                .commit()
            fragmentManager.beginTransaction()
                .add(containerId, fragment4, R.id.nav_menu_my_finance.toString())
                .hide(fragment4)
                .commit()
            fragmentManager.beginTransaction()
                .add(containerId, fragment1, R.id.nav_menu_doc_calls.toString())
                .commit()

            active = fragment1

            Log.d("FRAG CREATION ", (System.currentTimeMillis() - start).toString())
        }
    }

    fun setupBottomNavigationBackStack(previousBackStack: BackStack?) {
        navigationBackStack = previousBackStack?.let {
            it
        } ?: BackStack.of(appStartDestinationId)
    }

    fun onNavigationItemSelected(menuItemId: Int = navigationBackStack.last()): Boolean {

        Log.d(TAG, "onNavigationItemSelected ")
        // Replace fragment representing a navigation item

        //OPTION 2
        when (menuItemId) {
            R.id.nav_menu_doc_calls -> {
                fragmentManager.beginTransaction().hide(active!!).show(fragment1)
                    .addToBackStack(null).commit()
                active = fragment1
                (activity as MainActivity).hideTabLayout()
            }
            R.id.nav_menu_my_calls -> {
                fragmentManager.beginTransaction().hide(active!!).show(fragment2)
                    .addToBackStack(null).commit()
                active = fragment2
                (activity as MainActivity).showTabLayout()
            }
            R.id.nav_menu_my_finance -> {
                fragmentManager.beginTransaction().hide(active!!).show(fragment4)
                    .addToBackStack(null).commit()
                active = fragment4
                (activity as MainActivity).showTabLayout()
            }
            else -> {
                fragmentManager.beginTransaction().hide(active!!).show(fragment3)
                    .addToBackStack(null).commit()
                active = fragment3
                (activity as MainActivity).hideTabLayout()
            }
        }


//        val transaction = fragmentManager.beginTransaction()
//            .setCustomAnimations(
//                R.anim.fade_in,
//                R.anim.fade_out,
//                R.anim.fade_in,
//                R.anim.fade_out
//            )
//            .add(containerId, fragment!!, menuItemId.toString())
//
//        transaction.addToBackStack(null).commit()

        // Add to back stack
        navigationBackStack.moveLast(menuItemId)

        // Update checked icon
        navItemChangeListener.onItemChanged(menuItemId)

        // communicate with Activity
        graphChangeListener?.onGraphChange()

        return true
    }

    @SuppressLint("RestrictedApi")
    fun onBackPressed() {
        val navController = fragmentManager.findFragmentById(containerId)!!.findNavController()

        when {
            navController.backStack.size > 2 -> {
                navController.popBackStack()
            }

            // Fragment back stack is empty so try to go back on the navigation stack
            navigationBackStack.size > 1 -> {
                Log.d(TAG, "logInfo: BNC: backstack size > 1")

                // Remove last item from back stack
                navigationBackStack.removeLast()

                // Update the container with new fragment
                onNavigationItemSelected()
            }
            // If the stack has only one and it's not the navigation home we should
            // ensure that the application always leave from startDestination
            navigationBackStack.last() != appStartDestinationId -> {
                Log.d(TAG, "logInfo: BNC: start != current")
                navigationBackStack.removeLast()
                navigationBackStack.add(0, appStartDestinationId)
                onNavigationItemSelected()
            }
            // Navigation stack is empty, so finish the activity
            else -> {
                Log.d(TAG, "logInfo: BNC: FINISH")
                activity.finish()
            }
        }
    }

    @Parcelize
    class BackStack : ArrayList<Int>(), Parcelable {

        companion object {

            fun of(vararg elements: Int): BackStack {
                val b = BackStack()
                b.addAll(elements.toTypedArray())
                return b
            }
        }

        fun removeLast() = removeAt(size - 1)

        fun moveLast(item: Int) {
            remove(item) // if present, remove
            add(item) // add to end of list
        }

    }


    // For setting the checked icon in the bottom nav
    interface OnNavigationItemChanged {
        fun onItemChanged(itemId: Int)
    }

    // Execute when Navigation Graph changes.
    interface OnNavigationGraphChanged {
        fun onGraphChange()
    }

    interface OnNavigationReselectedListener {

        fun onReselectNavItem(navController: NavController, fragment: Fragment)
    }

    fun setOnItemNavigationChanged(listener: (itemId: Int) -> Unit) {
        this.navItemChangeListener = object : OnNavigationItemChanged {
            override fun onItemChanged(itemId: Int) {
                listener.invoke(itemId)
            }
        }
    }


}

// Convenience extension to set up the navigation
fun BottomNavigationView.setUpNavigation(
    bottomNavController: BottomNavControllerFix,
    onReselectListener: BottomNavControllerFix.OnNavigationReselectedListener
) {

    setOnNavigationItemSelectedListener {
        bottomNavController.onNavigationItemSelected(it.itemId)
    }

    setOnNavigationItemReselectedListener {
        bottomNavController
            .fragmentManager
            .findFragmentById(bottomNavController.containerId)!!
            .childFragmentManager
            .fragments[0]?.let { fragment ->

            onReselectListener.onReselectNavItem(
                bottomNavController.activity.findNavController(bottomNavController.containerId),
                fragment
            )
        }
        bottomNavController.onNavigationItemSelected()
    }

    bottomNavController.setOnItemNavigationChanged { itemId ->
        menu.findItem(itemId).isChecked = true
    }
}

