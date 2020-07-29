package com.anymobile.domvet.ui.addpost

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.domain.model.*
import com.anymobile.domvet.App
import com.anymobile.domvet.R
import com.anymobile.domvet.di.viewmodels.AddPostViewModelFactory
import com.anymobile.domvet.fragments.AddPostNavHostFragment
import com.anymobile.domvet.ui.BaseActivity
import com.anymobile.domvet.viewobjects.PassengerPostViewObj
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject
import javax.inject.Named


class AddPostActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: AddPostViewModelFactory


    private val viewmodel: AddPostViewModel by viewModels {
        viewModelFactory
    }

    @Inject
    @Named("AddPostFragmentFactory")
    lateinit var fragmentFactory: FragmentFactory


    override fun inject() {
        (application as App).addPostComponent()
            .inject(this)
    }


    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    @ExperimentalSplittiesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_post)
        setupActionBar()
        onRestoreInstanceState()


        subscribeObservers()
        setupListeners()
    }

    override fun onResume() {
        super.onResume()
        checkIfEditing(intent.getParcelableExtra(Constants.TXT_PASSENGER_POST))

    }

    private fun checkIfEditing(passengerPostViewObj: PassengerPostViewObj?) {
        if (passengerPostViewObj != null) {
            viewmodel.isEditing = true
            viewmodel.price = passengerPostViewObj.price
            viewmodel.seat = passengerPostViewObj.seat
            viewmodel.placeFrom = Place(passengerPostViewObj.from.districtId,
                                        passengerPostViewObj.from.regionId,
                                        passengerPostViewObj.from.lat,
                                        passengerPostViewObj.from.lon,
                                        passengerPostViewObj.from.regionName,
                                        passengerPostViewObj.from.name)

            viewmodel.placeTo = Place(passengerPostViewObj.to.districtId,
                                      passengerPostViewObj.to.regionId,
                                      passengerPostViewObj.to.lat,
                                      passengerPostViewObj.to.lon,
                                      passengerPostViewObj.from.regionName,
                                      passengerPostViewObj.from.name)

            viewmodel.timeFirstPart = passengerPostViewObj.timeFirstPart
            viewmodel.timeSecondPart = passengerPostViewObj.timeSecondPart
            viewmodel.timeThirdPart = passengerPostViewObj.timeThirdPart
            viewmodel.timeFourthPart = passengerPostViewObj.timeFourthPart
            viewmodel.departureDate = passengerPostViewObj.departureDate
            viewmodel.note = passengerPostViewObj.remark
            viewmodel.car = CarDetails(passengerPostViewObj.carId,
                                       IdName(2L, "MODEL 1"),
                                       Image(2L,
                                             "http://codeuz.uz:9091/attach/image/eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDIwLTA2LTIzLTIxLTA5LTA4LTgxMi5qcGciLCJpc3MiOiJwaXRha2oxMmJpaG1hbiIsImlhdCI6MTU5MzU5NDIxOH0.dpoNfy19v9pvFaFB9O3oZ-b0PTR78ukxGemaS_Jgzng"),
                                       Constants.FUEL_TYPE_METHANE,
                                       CarColor(3L, "#eb4034", "RED", "qizil", "KRASNIY"),
                                       "01XU239A", 2013, true, true, listOf(Image(2L,
                                                                                  "http://codeuz.uz:9091/attach/image/eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDIwLTA2LTIzLTIxLTA5LTA4LTgxMi5qcGciLCJpc3MiOiJwaXRha2oxMmJpaG1hbiIsImlhdCI6MTU5MzU5NDIxOH0.dpoNfy19v9pvFaFB9O3oZ-b0PTR78ukxGemaS_Jgzng")
                ))

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.previewFragment, true)
                .build()

            navHost.findNavController()
                .navigate(R.id.action_destinationsFragment_to_previewFragment,
                          null,
                          navOptions)
        }

    }


    private fun setupListeners() {


    }

    private fun subscribeObservers() {


    }


    var host: Fragment? = null
    lateinit var navHost: Fragment

    private fun onRestoreInstanceState() {
        host = supportFragmentManager.findFragmentById(R.id.add_post_fragments_container)
        host?.let { /*do nothing*/ } ?: createNavHost()
    }

    private fun createNavHost() {
        navHost = AddPostNavHostFragment.create(R.navigation.add_post_nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.add_post_fragments_container, navHost, getString(R.string.AuthNavHost))
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }


    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
