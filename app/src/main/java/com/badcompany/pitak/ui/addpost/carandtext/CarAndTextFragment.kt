package com.badcompany.pitak.ui.addpost.carandtext

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.badcompany.core.ErrorWrapper
import com.badcompany.core.ResultWrapper
import com.badcompany.core.exhaustive
import com.badcompany.domain.domainmodel.CarDetails
import com.badcompany.pitak.R
import com.badcompany.pitak.ui.addcar.MyItemClickListener
import com.badcompany.pitak.ui.addpost.AddPostViewModel
import com.badcompany.pitak.ui.viewgroups.CarItemSelectionView
import com.badcompany.pitak.ui.viewgroups.ErrorTextItem
import com.badcompany.pitak.ui.viewgroups.LoadingItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_car_and_note.*
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class CarAndTextFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_car_and_note) {


    private val adapter = GroupAdapter<GroupieViewHolder>()

    private val activityViewModel: AddPostViewModel by activityViewModels {
        viewModelFactory
    }

    private val viewModel: CarAndTextViewModel by viewModels {
        viewModelFactory
    }

    //    val args: PhoneConfirmFragmentArgs by navArgs()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        activityViewModel.cancelActiveJobs()
    }

    @ExperimentalSplittiesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupCarList()
        setupObservers()

        navController = findNavController()
//        confirm.isEnabled = true
//
//        code.setText(args.password)
//
//        confirm.setOnClickListener {
//            viewModel.confirm(args.phone, code.text.toString())
//        }

        viewModel.getCars()
    }

    private fun setupCarList() {
        carsList.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        carsList.setHasFixedSize(true)
        carsList.adapter = adapter

    }


    @ExperimentalSplittiesApi
    private fun setupListeners() {

        next.setOnClickListener {
            navController.navigate(R.id.action_carAndTextFragment_to_previewFragment)
        }

        navBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }


    @ExperimentalSplittiesApi
    private fun setupObservers() {
        viewModel.carsResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
                    showErrorMessage(response.message)
                }
                is ErrorWrapper.SystemError -> {
                    showErrorMessage(response.err.localizedMessage)
                }
                is ResultWrapper.Success -> {
                    populateCarsList(response.value)
                }
                ResultWrapper.InProgress -> {
                    adapter.clear()
                    adapter.add(LoadingItem())
                }
            }.exhaustive

        })

    }

    private fun showErrorMessage(message: String?) {

        adapter.clear()
        adapter.add(ErrorTextItem(message))
        adapter.notifyDataSetChanged()

    }

    private fun populateCarsList(cars: List<CarDetails>) {
        adapter.clear()
        cars.forEach { car ->
            adapter.add(CarItemSelectionView(car, object : MyItemClickListener {
                override fun onClick(pos: Int) {
                    super.onClick(pos)
                    for (i in 0 until adapter.itemCount) {
                        (adapter.getItem(i) as CarItemSelectionView).car.def = false
                    }
                    car.def = true
                    adapter.notifyDataSetChanged()
                }
            }))
        }
    }


    override fun onPause() {
        super.onPause()

    }

    @ExperimentalSplittiesApi
    override fun onResume() {
        super.onResume()
        viewModel.getCars()
//        (activity as AddPostActivity).showActionBar()
    }


}



