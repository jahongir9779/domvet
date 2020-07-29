package com.anymobile.domvet.ui.main.mycalls

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anymobile.domvet.R
import com.anymobile.domvet.ui.main.MainActivity
import com.anymobile.domvet.ui.main.mycalls.activecalls.ActiveCallsFragment
import com.anymobile.domvet.ui.main.mycalls.historycalls.HistoryCallsFragment
import com.google.android.material.tabs.TabLayoutMediator
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
        (activity as MainActivity).showTabLayout()

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
        val pagerAdapter = ScreenSlidePagerAdapter(childFragmentManager)
        pager.adapter = pagerAdapter
        TabLayoutMediator(requireActivity().findViewById(R.id.tab_layout), pager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.active)
                else -> getString(R.string.history)
            }
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) :
        FragmentStateAdapter(this) {

        lateinit var currentFrag: Fragment
        var activeOrdersFrag = ActiveCallsFragment(viewModelFactory)
        var historyOrdersFrag = HistoryCallsFragment(viewModelFactory)

        override fun getItemCount() = 2

        override fun createFragment(position: Int): Fragment {
            currentFrag = when (position) {
                0 -> activeOrdersFrag
                else -> historyOrdersFrag
            }
            return currentFrag
        }

    }

}