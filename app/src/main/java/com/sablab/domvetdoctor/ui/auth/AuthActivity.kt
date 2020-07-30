package com.sablab.domvetdoctor.ui.auth

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.di.viewmodels.AuthViewModelFactory
import com.sablab.domvetdoctor.fragments.AuthNavHostFragment
import com.sablab.domvetdoctor.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject
import javax.inject.Named

class AuthActivity : BaseActivity() {


    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory

    @Inject
    @Named("AuthFragmentFactory")
    lateinit var fragmentFactory: FragmentFactory

    private val viewModel: AuthViewModel by viewModels {
        viewModelFactory
    }

//    lateinit var navController: NavController

    override fun inject() {
        (application as App).authComponent()
            .inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
//        navController = findNavController(R.id.auth_fragments_container)

        subscribeObservers()
        onRestoreInstanceState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

    }

    private fun subscribeObservers() {

    }

    var host: Fragment? = null
    lateinit var navHost: Fragment

    private fun onRestoreInstanceState() {
        host = supportFragmentManager.findFragmentById(R.id.auth_fragments_container)
        host?.let { /*do nothing*/ } ?: createNavHost()
    }

    private fun createNavHost() {
        navHost = AuthNavHostFragment.create(R.navigation.nav_auth_graph)
        supportFragmentManager.beginTransaction().replace(R.id.auth_fragments_container,
                                                          navHost,
                                                          getString(R.string.AuthNavHost))
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


}

