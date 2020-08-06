package com.sablab.domvetdoctor.ui.registration

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.di.viewmodels.RegistrationViewModelFactory
import com.sablab.domvetdoctor.fragments.RegistrationNavHostFragment
import com.sablab.domvetdoctor.ui.BaseActivity
import com.sablab.domvetdoctor.util.REQUEST_GALLERY
import com.sablab.domvetdoctor.util.REQUEST_IMAGE_CAPTURE
import kotlinx.android.synthetic.main.activity_registration.*
import javax.inject.Inject
import javax.inject.Named

class RegistrationActivity : BaseActivity() {


    @Inject
    lateinit var viewModelFactory: RegistrationViewModelFactory

    @Inject
    @Named("RegistrationFragmentFactory")
    lateinit var fragmentFactory: FragmentFactory

     val viewModel: RegistrationViewModel by viewModels {
        viewModelFactory
    }

//    lateinit var navController: NavController

    override fun inject() {
        (application as App).registrationComponent()
            .inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
//        navController = findNavController(R.id.register_fragments_container)

        subscribeObservers()
        onRestoreInstanceState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

    }

    private fun subscribeObservers() {

    }

    fun setRegProgress(progress: Int) {
        progressBar.progress = progress
    }

    var host: Fragment? = null
    lateinit var navHost: Fragment

    private fun onRestoreInstanceState() {
        host = supportFragmentManager.findFragmentById(R.id.register_fragments_container)
        host?.let { /*do nothing*/ } ?: createNavHost()
    }

    private fun createNavHost() {
        navHost = RegistrationNavHostFragment.create(R.navigation.nav_register_graph)
        supportFragmentManager.beginTransaction().replace(R.id.register_fragments_container,
                                                          navHost,
                                                          getString(R.string.RegisterNavHost))
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {

            when (requestCode.toString().substring(2).toInt()) {
                REQUEST_GALLERY -> {
                    viewModel.setImageUri(data!!.data,
                                          requestCode.toString().substring(0, 2).toInt())
                }
                REQUEST_IMAGE_CAPTURE -> {
                    val bitmapImg = data!!.extras!!.get("data") as Bitmap
                    viewModel.setImageBitmap(bitmapImg, requestCode.toString().substring(0, 2).toInt())
                }
            }


        }
    }
}

