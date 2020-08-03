package com.sablab.domvetdoctor.ui.main.doccalls

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sablab.domvetdoctor.R
import com.skydoves.balloon.Balloon
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_doc_calls.*
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject

@ExperimentalSplittiesApi
class DocCallsFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_doc_calls) {

    private lateinit var balloon: Balloon
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel: DocCallsViewModel by viewModels {
        viewModelFactory
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        setupListeners()
        setupRecyclerView()
        viewModel.getPassengerPost()
        subscribeObservers()

    }

    private fun setupListeners() {

    }


    private fun subscribeObservers() {

    }

    private fun setupRecyclerView() {
        activeCalls.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        activeCalls.setHasFixedSize(true)
        activeCalls.adapter = adapter
    }




}