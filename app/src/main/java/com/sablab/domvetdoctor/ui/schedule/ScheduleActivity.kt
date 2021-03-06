package com.sablab.domvetdoctor.ui.schedule

import android.os.Bundle
import androidx.activity.viewModels
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.di.viewmodels.ProfileViewModelFactory
import com.sablab.domvetdoctor.di.viewmodels.SelectCityViewModelFactory
import com.sablab.domvetdoctor.ui.BaseActionbarActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import javax.inject.Inject

class ScheduleActivity : BaseActionbarActivity() {


    @Inject
    lateinit var viewModelFactory: ProfileViewModelFactory


    private val actViewModel: ScheduleViewModel by viewModels {
        viewModelFactory
    }

//    lateinit var navController: NavController

    override fun inject() {
        (application as App).profileComponent()
            .inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        setContentView(R.layout.activity_schedule)
        setSupportActionBar(tool_bar)
        super.onCreate(savedInstanceState)
//        navController = findNavController(R.id.auth_fragments_container)

        subscribeObservers()


    }

    private fun subscribeObservers() {

    }





    override fun onDestroy() {
        super.onDestroy()
        (application as App).releaseProfileComponent()
    }
}

