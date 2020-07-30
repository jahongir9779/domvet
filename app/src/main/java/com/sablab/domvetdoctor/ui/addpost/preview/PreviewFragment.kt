package com.sablab.domvetdoctor.ui.addpost.preview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.domain.model.Place
import com.sablab.domvetdoctor.ui.addpost.AddPostViewModel
import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.util.exhaustive
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_preview.*
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class PreviewFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_preview) {


    private val adapter = GroupAdapter<GroupieViewHolder>()
    private var placeFrom: Place? = null
    private var placeTo: Place? = null

    private val activityViewModel: AddPostViewModel by activityViewModels {
        viewModelFactory
    }

    private val viewModel: PreviewViewModel by viewModels {
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
        setupObservers()
        setupListeners()
        setupViews()
        navController = findNavController()
//        confirm.isEnabled = true
//
//        code.setText(args.password)
//
//        confirm.setOnClickListener {
//            viewModel.confirm(args.phone, code.text.toString())
//        }

//        setupCarList()
    }

    private fun setupViews() {
        if (activityViewModel.isEditing) navBack.visibility = View.INVISIBLE
        labelFrom.text = activityViewModel.placeFrom!!.name
        labelTo.text = activityViewModel.placeTo!!.name


        var time = ""
        if (activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = getString(R.string.anytime)
        } else if (activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && !activityViewModel.timeFourthPart) {
            time = "00:00 - 18:00"
        } else if (activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && !activityViewModel.timeThirdPart && !activityViewModel.timeFourthPart) {
            time = "00:00 - 12:00"
        } else if (activityViewModel.timeFirstPart && !activityViewModel.timeSecondPart && !activityViewModel.timeThirdPart && !activityViewModel.timeFourthPart) {
            time = "00:00 - 6:00"
        } else if (!activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "6:00 - 00:00"
        } else if (!activityViewModel.timeFirstPart && !activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "12:00 - 00:00"
        } else if (!activityViewModel.timeFirstPart && !activityViewModel.timeSecondPart && !activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "18:00 - 00:00"
        } else if (activityViewModel.timeFirstPart && !activityViewModel.timeSecondPart && !activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "00:00 - 6:00, 18:00-00:00"
        } else if (!activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && !activityViewModel.timeFourthPart) {
            time = "6:00 - 18:00"
        } else if (activityViewModel.timeFirstPart && !activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "00:00 - 6:00, 12:00 - 00:00"
        } else if (activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && !activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "00:00 - 12:00, 18:00 - 00:00"
        } else if (activityViewModel.timeFirstPart && !activityViewModel.timeSecondPart && activityViewModel.timeThirdPart && !activityViewModel.timeFourthPart) {
            time = "00:00 - 6:00, 12:00 - 18:00"
        } else if (!activityViewModel.timeFirstPart && activityViewModel.timeSecondPart && !activityViewModel.timeThirdPart && activityViewModel.timeFourthPart) {
            time = "6:00 - 12:00, 18:00 - 00:00"
        }

        dateTime.text =
            getString(R.string.departure_date_and_time, activityViewModel.departureDate, time)

        priceAndSeat.text = getString(R.string.price_and_seats_format,
                                      activityViewModel.price.toString(),
                                      activityViewModel.seat.toString())


        if (activityViewModel.note.isNullOrBlank()) {
            note.visibility = View.GONE
        } else {
            note.visibility = View.VISIBLE
            note.text = activityViewModel.note
        }


    }


    @ExperimentalSplittiesApi
    private fun setupListeners() {


        navBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        layoutDestinations.setOnClickListener {
            navController.navigate(PreviewFragmentDirections.actionPreviewFragmentToDestinationsFragment(
                true))
        }
        dateTime.setOnClickListener {
            navController.navigate(PreviewFragmentDirections.actionPreviewFragmentToDateTimeFragment(
                true))
        }
        priceAndSeat.setOnClickListener {
            navController.navigate(PreviewFragmentDirections.actionPreviewFragmentToPriceAndSeatFragment(
                true))
        }
        note.setOnClickListener {
            navController.navigate(PreviewFragmentDirections.actionPreviewFragmentToCarAndTextFragment(
                true))
        }

        postCreate.setOnClickListener {
            viewModel.createPassengerPost(PassengerPost(null,
                                                        activityViewModel.placeFrom!!,
                                                        activityViewModel.placeTo!!,
                                                        activityViewModel.price!!,
                                                        activityViewModel.departureDate!!,
                                                        null,
                                                        null,
                                                        null,
                                                        activityViewModel.timeFirstPart,
                                                        activityViewModel.timeSecondPart,
                                                        activityViewModel.timeThirdPart,
                                                        activityViewModel.timeFourthPart,
                                                        null,
                                                        activityViewModel.note!!,
                                                        null,
                                                        activityViewModel.seat!!,
                                                        Constants.PASSENGER_POST_SIMPLE))
        }

    }

//    private fun setupCarList() {
//        selectedCarList.layoutManager =
//            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//        selectedCarList.setHasFixedSize(true)
//        adapter.clear()
//        selectedCarList.adapter = adapter
//        adapter.add(CarItemSelectionView(activityViewModel.car!!, object : MyItemClickListener {
//            override fun onClick(pos: Int, view: View) {
//                super.onClick(pos)
//                navController.navigate(PreviewFragmentDirections.actionPreviewFragmentToCarAndTextFragment(
//                    true))
//            }
//        }))
//    }

    @ExperimentalSplittiesApi
    private fun setupObservers() {
        viewModel.createResponse.observe(viewLifecycleOwner, Observer {
            val response = it ?: return@Observer

            when (response) {
                is ErrorWrapper.ResponseError -> {
                    postCreate.revertAnimation()
                    Snackbar.make(scrollView, response.message.toString(), Snackbar.LENGTH_SHORT)
                        .show()
                }
                is ErrorWrapper.SystemError -> {
                    postCreate.revertAnimation()
                    Snackbar.make(scrollView,
                                  response.err.localizedMessage!!,
                                  Snackbar.LENGTH_SHORT)
                        .show()
                }
                is ResultWrapper.Success -> {
                    postCreate.stopAnimation()
                    requireActivity().finish()
                }
                ResultWrapper.InProgress -> {
                    postCreate.startAnimation()
                }
            }.exhaustive

        })

    }


    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()
//        (activity as AddPostActivity).showActionBar()
    }


}




