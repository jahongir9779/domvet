package com.sablab.domvetdoctor.ui.main.mycalls

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.main.adapters.ScreenSlidePagerAdapter
import com.sablab.domvetdoctor.ui.main.mycalls.activecalls.ActiveCallsFragment
import com.sablab.domvetdoctor.ui.main.mycalls.historycalls.HistoryCallsFragment
import kotlinx.android.synthetic.main.fragment_my_calls.*
import javax.inject.Inject

class MyCallsFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_my_calls) {

    private val viewModel: MyCallsViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
//        (activity as MainActivity).showTabLayout()

//        change_password.setOnClickListener {
//            findNavController().navigate(R.id.action_accountFragment_to_changePasswordFragment)
//        }
//
//        logout_button.setOnClickListener {
//            viewModel.logout()
//        }
//
//        subscribeObservers()
        setupViewPager()
    }

    private fun setupViewPager() {
        val pagerAdapter =
            ScreenSlidePagerAdapter(requireActivity(), ActiveCallsFragment(viewModelFactory),
                                    HistoryCallsFragment(viewModelFactory))
        pager.adapter = pagerAdapter
        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.active)
                else -> getString(R.string.done)
            }
        }.attach()
    }

}