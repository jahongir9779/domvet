package com.sablab.domvetdoctor.ui.addpost.datetime

//import org.joda.time.DateTime
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.addpost.AddPostViewModel
import kotlinx.android.synthetic.main.fragment_date_and_time.*
import splitties.experimental.ExperimentalSplittiesApi
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class DateAndTimeFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_date_and_time) {

    val args: DateAndTimeFragmentArgs by navArgs()

    private var selectedDate: String? = null
    private var timeFirstPart = false
    private var timeSecondPart = false
    private var timeThirdPart = false
    private var timeFourthPart = false
    val dateFormat = SimpleDateFormat("dd.MM.yyyy")

    private val activityViewModel: AddPostViewModel by activityViewModels {
        viewModelFactory
    }

    //    val args: PhoneConfirmFragmentArgs by navArgs()
    lateinit var navController: NavController

    @ExperimentalSplittiesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupListeners()
        if (args.ISFROMPOSTPREVIEW) {
            checkFirstPartDay.isChecked = activityViewModel.timeFirstPart
            checkSecondPartDay.isChecked = activityViewModel.timeSecondPart
            checkThirdPartDay.isChecked = activityViewModel.timeThirdPart
            checkFourthPartDay.isChecked = activityViewModel.timeFourthPart
        }

        navController = findNavController()
        setupCalendar()
        updateNextButtonState()
    }

    private fun setupCalendar() {
//        calendar.state().edit().setMinimumDate(CalendarDay.today()).commit()
//        calendar.selectedDate = CalendarDay.today()

        val cal = Calendar.getInstance()

        calendar.minDate = cal.timeInMillis

        if (!args.ISFROMPOSTPREVIEW) {
            calendar.date = Calendar.getInstance().timeInMillis
            selectedDate = dateFormat.format(cal.time)
        } else {
            calendar.date = dateFormat.parse(activityViewModel.departureDate).time
            selectedDate = activityViewModel.departureDate
        }

    }


    @ExperimentalSplittiesApi
    private fun setupListeners() {
        asapCheck.setOnCheckedChangeListener { buttonView, isChecked ->

            checkSecondPartDay.isEnabled = !isChecked
            checkThirdPartDay.isEnabled = !isChecked
            checkFirstPartDay.isEnabled = !isChecked
            checkFourthPartDay.isEnabled = !isChecked

            checkSecondPartDay.isChecked = isChecked
            checkThirdPartDay.isChecked = isChecked
            checkFirstPartDay.isChecked = isChecked
            checkFourthPartDay.isChecked = isChecked


            if (isChecked) {
//                calendar.selectedDate = CalendarDay.today()
//                calendar.state().edit()
//                    .setMinimumDate(CalendarDay.today())
//                    .setMaximumDate(CalendarDay.today())
//                    .commit()

              var cal = Calendar.getInstance().timeInMillis
                calendar.date =cal
                selectedDate = dateFormat.format(cal)
            } else {
//                val todayPlusThreeMonths = DateTime.now().plusMonths(3)
//                calendar.state().edit().setMinimumDate(CalendarDay.today())
//                    .setMaximumDate(CalendarDay.from(todayPlusThreeMonths.year,
//                                                     todayPlusThreeMonths.monthOfYear,
//                                                     todayPlusThreeMonths.dayOfMonth)).commit()


            }

        }


        checkFirstPartDay.setOnCheckedChangeListener { buttonView, isChecked ->
            timeFirstPart = isChecked
            updateNextButtonState()
        }
        checkSecondPartDay.setOnCheckedChangeListener { buttonView, isChecked ->
            timeSecondPart = isChecked
            updateNextButtonState()
        }
        checkThirdPartDay.setOnCheckedChangeListener { buttonView, isChecked ->
            timeThirdPart = isChecked
            updateNextButtonState()
        }
        checkFourthPartDay.setOnCheckedChangeListener { buttonView, isChecked ->
            timeFourthPart = isChecked
            updateNextButtonState()
        }

//        calendar.setOnDateChangedListener { widget, date, selected ->
//            val cal = Calendar.getInstance()
//            cal[Calendar.YEAR] = date.year
//            cal[Calendar.MONTH] = date.month - 1
//            cal[Calendar.DAY_OF_MONTH] = date.day
//            selectedDate = dateFormat.format(cal.time)
//        }

        navNext.setOnClickListener {
            activityViewModel.departureDate = selectedDate
            activityViewModel.timeFirstPart = timeFirstPart
            activityViewModel.timeSecondPart = timeSecondPart
            activityViewModel.timeThirdPart = timeThirdPart
            activityViewModel.timeFourthPart = timeFourthPart

            navController.navigate(if (args.ISFROMPOSTPREVIEW) R.id.action_dateTimeFragment_to_previewFragment else R.id.action_dateTimeFragment_to_priceAndSeatFragment)
        }

        navBack.setOnClickListener {
            requireActivity().onBackPressed()
        }


        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal[Calendar.YEAR] = year
            cal[Calendar.MONTH] = month
            cal[Calendar.DAY_OF_MONTH] = dayOfMonth
            selectedDate = dateFormat.format(cal.time)
            asapCheck.isChecked = false
        }

    }

    private fun updateNextButtonState() {
        navNext.isEnabled =
            !(!timeFirstPart && !timeSecondPart && !timeThirdPart && !timeFourthPart) && selectedDate != null

        if (navNext.isEnabled) {
            val bg = navNext.background
            bg.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary),
                              PorterDuff.Mode.SRC_ATOP)
            navNext.background = bg
        } else {
            val bg = navNext.background
            bg.setColorFilter(ContextCompat.getColor(requireContext(), R.color.ic_grey),
                              PorterDuff.Mode.SRC_ATOP)
            navNext.background = bg
        }
    }

    @ExperimentalSplittiesApi
    private fun setupObservers() {
//        viewModel.fromPlacesResponse.observe(viewLifecycleOwner, Observer {
//            val response = it ?: return@Observer
//
//            when (response) {
//                is ErrorWrapper.ResponseError -> {
//
//                }
//                is ErrorWrapper.SystemError -> {
//
//                }
//                is ResultWrapper.Success -> {
//                    fromAutocompletePresenter.getAdr().clear()
//                    response.value.forEach { place ->
//                        fromAutocompletePresenter.getAdr().add(PlaceAutocompleteItemView(place,
//                                                                                        fromAutocompletePresenter))
//
//                    }
//                    fromAutocompletePresenter.getAdr().notifyDataSetChanged()
//                }
//                ResultWrapper.InProgress -> {
//                    if (fromAutocompletePresenter.getAdr().itemCount == 0 || fromAutocompletePresenter.getAdr().getItem(
//                            fromAutocompletePresenter.getAdr().itemCount - 1) !is LoadingItemSmall) {
//                        fromAutocompletePresenter.getAdr().add(LoadingItemSmall())
//                        fromAutocompletePresenter.getAdr().notifyDataSetChanged()
//                    } else {
//
//                    }
//                }
//            }.exhaustive
//
//        })

    }


}




