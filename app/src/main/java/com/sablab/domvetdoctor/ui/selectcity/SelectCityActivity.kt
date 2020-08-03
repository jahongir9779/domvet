package com.sablab.domvetdoctor.ui.selectcity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sablab.domvetdoctor.App
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.di.viewmodels.SelectCityViewModelFactory
import com.sablab.domvetdoctor.models.City
import com.sablab.domvetdoctor.ui.BaseActionbarActivity
import com.sablab.domvetdoctor.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_select_city.*
import javax.inject.Inject

class SelectCityActivity : BaseActionbarActivity() {


    companion object {
        const val CITY_ACTIVITY_RESULT = 999
    }

    @Inject
    lateinit var viewModelFactory: SelectCityViewModelFactory


    private val actViewModel: SelectCityActViewModel by viewModels {
        viewModelFactory
    }

//    lateinit var navController: NavController

    override fun inject() {
        (application as App).selectCityComponent()
            .inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        setContentView(R.layout.activity_select_city)
        setSupportActionBar(tool_bar)
        super.onCreate(savedInstanceState)
//        navController = findNavController(R.id.auth_fragments_container)
        initViews()
        initObjects()
        subscribeObservers()


    }

    private fun subscribeObservers() {

    }





    private val adapter by lazy {
        CityAdapter {
            val intent = Intent()
            intent.putExtra(City.CITY, it)
            setResult(Activity.RESULT_OK, intent)
            finish()
//            actViewModel.setSelectedCity(it)
        }
    }


    private fun initObjects() {
        actViewModel.cities.observe(this, Observer {
            adapter.setDatas(it)
        })

        actViewModel.downloadCities()

        actViewModel.progress.observe(this, Observer {
            sp_cities.isRefreshing = it.peekContent()
        })
    }

    private fun initViews() {
        rv_cities.adapter = adapter

        sp_cities.setOnRefreshListener {
            actViewModel.downloadCities()
        }
        // listening to search query text change
        search_view.setOnClickListener {
            search_view.isIconified = !search_view.isIconified
        }
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // filter recycler view when query submitted
                adapter.filter?.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                // filter recycler view when text is changed
                adapter.filter?.filter(query)
                return false
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        (application as App).releaseSelectCityComponent()
    }
}

