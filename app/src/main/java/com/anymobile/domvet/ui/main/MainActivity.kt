package com.anymobile.domvet.ui.main

import android.animation.LayoutTransition
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import com.anymobile.domvet.App
import com.anymobile.domvet.R
import com.anymobile.domvet.di.viewmodels.MainViewModelFactory
import com.anymobile.domvet.fragments.MainNavHostFragment
import com.anymobile.domvet.ui.BaseActivity
import com.anymobile.domvet.ui.addpost.AddPostActivity
import com.anymobile.domvet.ui.auth.AuthActivity
import com.anymobile.domvet.ui.main.finance.FinanceFragment
import com.anymobile.domvet.ui.main.mycalls.MyCallsFragment
import com.anymobile.domvet.ui.main.profile.ProfileFragment
import com.anymobile.domvet.ui.main.searchtrip.SearchTripFragment
import com.anymobile.domvet.util.AppPreferences
import com.anymobile.domvet.util.BOTTOM_NAV_BACKSTACK_KEY
import com.anymobile.domvet.util.BottomNavControllerFix
import com.anymobile.domvet.util.setUpNavigation
import kotlinx.android.synthetic.main.activity_main.*
import splitties.activities.start
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity(), BottomNavControllerFix.OnNavigationGraphChanged,
    BottomNavControllerFix.OnNavigationReselectedListener {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    @Inject
    @Named("MainFragmentFactory")
    lateinit var fragmentFactory: FragmentFactory

    override fun inject() {
        (application as App).mainComponent()
            .inject(this)
    }

    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    private val bottomNavControllerFix by lazy(LazyThreadSafetyMode.NONE) {
        BottomNavControllerFix(
            this,
            R.id.main_fragments_container,
            R.id.nav_menu_doc_calls,
            this)
    }

    @ExperimentalSplittiesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        checkUserLogin()
        inject()
        setTheme(R.style.NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app_bar.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        setupActionBar()
        setupListeners()
        subscribeObservers()
//        onRestoreInstanceState()
        setupBottomNavigationView(savedInstanceState)

    }

    private fun setupListeners() {
        addPost.setOnClickListener {
            start<AddPostActivity>()
        }
    }

    @ExperimentalSplittiesApi
    private fun checkUserLogin() {
        if (AppPreferences.token.isBlank()) {
            start<AuthActivity> { }
        }
    }

    private fun setupBottomNavigationView(savedInstanceState: Bundle?) {
        nav_view.setUpNavigation(bottomNavControllerFix, this)
        if (savedInstanceState == null) {
            bottomNavControllerFix.setupBottomNavigationBackStack(null)
            bottomNavControllerFix.onNavigationItemSelected()
        } else {
            (savedInstanceState[BOTTOM_NAV_BACKSTACK_KEY] as IntArray?)?.let { items ->
                val backstack = BottomNavControllerFix.BackStack()
                backstack.addAll(items.toTypedArray())
                bottomNavControllerFix.setupBottomNavigationBackStack(backstack)
            }
        }
    }


    private fun subscribeObservers() {
//        TODO("Not yet implemented")
    }

    override fun onReselectNavItem(
        navController: NavController,
        fragment: Fragment
    ) {
        Log.d(TAG, "logInfo: onReSelectItem")
        when (fragment) {
            is SearchTripFragment -> {
//                navController.navigate(R.id.action_nav_menu_doc_calls_self)
            }

            is MyCallsFragment -> {
//                navController.navigate(R.id.action_nav_menu_my_calls_self)
            }

            is FinanceFragment -> {
//                navController.navigate(R.id.action_nav_menu_profile_self)
            }
            is ProfileFragment -> {
//                navController.navigate(R.id.action_nav_menu_profile_self)
            }
            else -> {
                // do nothing
            }
        }
    }

    private fun onRestoreInstanceState() {
        val host = supportFragmentManager.findFragmentById(R.id.main_fragments_container)
        host?.let { } ?: createNavHost()
    }

    private fun createNavHost() {
        val navHost = MainNavHostFragment.create(R.navigation.main_nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragments_container, navHost, getString(
                R.string.MainNavHost))
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }

    override fun onGraphChange() {

    }

    override fun onBackPressed() = bottomNavControllerFix.onBackPressed()

    private fun setupActionBar() {
//        setSupportActionBar(tool_bar)
    }

    fun showTabLayout() {
        tab_layout.visibility = View.VISIBLE
    }

    fun hideTabLayout() {
        tab_layout.visibility = View.GONE
    }


}

