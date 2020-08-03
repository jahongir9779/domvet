package com.sablab.domvetdoctor.ui.calldone

import android.os.Bundle
import androidx.activity.viewModels
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.di.viewmodels.CallViewModelFactory
import com.sablab.domvetdoctor.di.viewmodels.SelectCityViewModelFactory
import com.sablab.domvetdoctor.ui.BaseActionbarActivity
import kotlinx.android.synthetic.main.activity_call_done.*
import javax.inject.Inject

class CallDoneActivity : BaseActionbarActivity() {


    @Inject
    lateinit var viewModelFactory: CallViewModelFactory


    private val actViewModel: CallDoneViewModel by viewModels {
        viewModelFactory
    }

//    lateinit var navController: NavController

    override fun inject() {
        (application as App).callComponent()
            .inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        setContentView(R.layout.activity_call_done)
        setSupportActionBar(tool_bar)
        super.onCreate(savedInstanceState)
//        navController = findNavController(R.id.auth_fragments_container)

        subscribeObservers()


    }

    private fun subscribeObservers() {

    }





    override fun onDestroy() {
        super.onDestroy()
        (application as App).releasecallComponent()
    }
}

