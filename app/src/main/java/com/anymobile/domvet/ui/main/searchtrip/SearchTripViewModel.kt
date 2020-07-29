package com.anymobile.domvet.ui.main.searchtrip

import androidx.lifecycle.viewModelScope
import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.Filter
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.model.Place
import com.anymobile.domvet.domain.usecases.GetDriverPostWithFilter
import com.anymobile.domvet.domain.usecases.GetPlacesFeed
import com.anymobile.domvet.ui.BaseViewModel
import com.anymobile.domvet.util.AppPreferences
import com.anymobile.domvet.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject

class SearchTripViewModel @Inject constructor(val getDriverPostWithFilter: GetDriverPostWithFilter,
                                              private val getPlacesFeed: GetPlacesFeed) :
    BaseViewModel() {


    val passengerPostsReponse = SingleLiveEvent<ResultWrapper<List<DriverPost>>>()
    var currentPage = 0
    var filter = Filter()

    @ExperimentalSplittiesApi
    fun getPassengerPost() {
        passengerPostsReponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = getDriverPostWithFilter.execute(hashMapOf(
                Pair(Constants.TXT_TOKEN, AppPreferences.token),
                Pair(Constants.TXT_LANG, AppPreferences.language),
                Pair(Constants.TXT_FILTER, filter)))

            withContext(Dispatchers.Main) {
                passengerPostsReponse.value = response
            }

        }

    }


    private var fromFeedJob: Job? = null
    private var toFeedJob: Job? = null
    val fromPlacesResponse = SingleLiveEvent<ResultWrapper<List<Place>>>()
    val toPlacesResponse = SingleLiveEvent<ResultWrapper<List<Place>>>()


    @ExperimentalSplittiesApi
    fun getPlacesFeed(queryString: String, isFrom: Boolean = true) {
        if (isFrom) fromPlacesResponse.value = ResultWrapper.InProgress
        else toPlacesResponse.value = ResultWrapper.InProgress
        resetFromFeedJob(isFrom)
        viewModelScope.launch(Dispatchers.IO + if (isFrom) fromFeedJob!! else toFeedJob!!) {
            val response =
                getPlacesFeed.execute(hashMapOf(Pair(Constants.TXT_TOKEN,
                                                     AppPreferences.token),
                                                Pair(Constants.TXT_LANG,
                                                     AppPreferences.language),
                                                Pair(Constants.TXT_PLACE, queryString)))

            withContext(Dispatchers.Main) {
                if (isFrom) fromPlacesResponse.value = response
                else toPlacesResponse.value = response
            }
        }
    }

    private fun resetFromFeedJob(isFrom: Boolean) {
        fromFeedJob?.cancel()
        fromFeedJob = Job()
        toFeedJob?.cancel()
        toFeedJob = Job()

    }

    override fun onCleared() {
        super.onCleared()
        fromFeedJob?.cancel()
        toFeedJob?.cancel()
    }

    fun resetFilter() {
        filter = Filter()
    }



}