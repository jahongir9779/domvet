package com.sablab.domvetdoctor.ui.biography

import android.os.Bundle
import androidx.activity.viewModels
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.di.viewmodels.ProfileViewModelFactory
import com.sablab.domvetdoctor.di.viewmodels.SelectCityViewModelFactory
import com.sablab.domvetdoctor.ui.BaseActionbarActivity
import kotlinx.android.synthetic.main.activity_biography.*
import javax.inject.Inject

class BiographyActivity : BaseActionbarActivity() {


    @Inject
    lateinit var viewModelFactory: ProfileViewModelFactory


    private val actViewModel: BiographyViewModel by viewModels {
        viewModelFactory
    }

//    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        setContentView(R.layout.activity_biography)
        setSupportActionBar(tool_bar)
        super.onCreate(savedInstanceState)
//        navController = findNavController(R.id.auth_fragments_container)

        subscribeObservers()


    }


    override fun inject() {
        (application as App).profileComponent()
            .inject(this)
    }

    private fun subscribeObservers() {

    }





    override fun onDestroy() {
        super.onDestroy()
        (application as App).releaseProfileComponent()
    }
}

