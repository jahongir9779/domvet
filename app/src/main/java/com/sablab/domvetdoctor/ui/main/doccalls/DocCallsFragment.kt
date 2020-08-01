package com.sablab.domvetdoctor.ui.main.doccalls

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.domain.model.DriverPost
import com.sablab.domvetdoctor.ui.interfaces.MyItemClickListener
import com.sablab.domvetdoctor.ui.viewgroups.DriverPostItem
import com.sablab.domvetdoctor.ui.viewgroups.LoadingItemSmall
import com.sablab.domvetdoctor.ui.viewgroups.PlaceFeedItemView
import com.sablab.domvetdoctor.util.*
import com.google.android.material.snackbar.Snackbar
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

    lateinit var autoCompleteManager: AutoCompleteManager

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
        viewModel.fromPlacesResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
                }
                is ErrorWrapper.SystemError -> {
                }
                is ResultWrapper.Success -> {
                    autoCompleteManager.fromPresenter.getAdr()!!.clear()
                    response.value.forEach { place ->
                        autoCompleteManager.fromPresenter.getAdr()!!
                            .add(PlaceFeedItemView(place,
                                                   autoCompleteManager.fromPresenter))

                    }
                    autoCompleteManager.fromPresenter.getAdr()!!.notifyDataSetChanged()
                }
                ResultWrapper.InProgress -> {
                }
            }.exhaustive

        })

        viewModel.toPlacesResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
                }
                is ErrorWrapper.SystemError -> {
                }
                is ResultWrapper.Success -> {
                    if (autoCompleteManager.toPresenter.getAdr() != null) {
                        autoCompleteManager.toPresenter.getAdr()!!.clear()
                        response.value.forEach { place ->
                            autoCompleteManager.toPresenter.getAdr()!!
                                .add(PlaceFeedItemView(place,
                                                       autoCompleteManager.toPresenter))
                        }
                        autoCompleteManager.toPresenter.getAdr()!!
                            .notifyDataSetChanged()
                    } else {
                    }
                }
                ResultWrapper.InProgress -> {
                }
            }.exhaustive

        })

        viewModel.passengerPostsReponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer
            when (response) {
                is ErrorWrapper.ResponseError -> {
//                    Snackbar.make(nestedScroll,
//                                  response.message!!,
//                                  Snackbar.LENGTH_SHORT).show()

                }
                is ErrorWrapper.SystemError -> {
//                    Snackbar.make(nestedScroll,
//                                  response.err.localizedMessage.toString(),
//                                  Snackbar.LENGTH_SHORT).show()
                }
                is ResultWrapper.Success -> {
                    loadData(response.value)
                }
                ResultWrapper.InProgress -> {
                    addLoading()
                }
            }.exhaustive
        })

    }

    private fun setupRecyclerView() {
        activeCalls.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        activeCalls.setHasFixedSize(true)
        activeCalls.adapter = adapter
    }

    private fun addLoading() {
        adapter.clear()
        adapter.add(LoadingItemSmall())
        adapter.notifyDataSetChanged()
    }

    private fun loadData(value: List<DriverPost>) {
        adapter.clear()

        if (value.isEmpty()) {
            infoText.visibility = View.VISIBLE
            infoText.text = getString(R.string.no_posts_found)
        } else {
            infoText.visibility = View.INVISIBLE
            value.forEach {
                adapter.add(DriverPostItem(it, object : MyItemClickListener {
                    override fun onClick(pos: Int) {
                        super.onClick(pos)
                    }
                }))
            }
        }
        adapter.notifyDataSetChanged()

    }


}