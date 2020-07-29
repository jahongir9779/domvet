package com.anymobile.domvet.ui.main.mytrips.activetrips

import androidx.lifecycle.viewModelScope
import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.domain.usecases.DeletePassengerPost
import com.anymobile.domvet.domain.usecases.FinishPassengerPost
import com.anymobile.domvet.domain.usecases.GetActivePassengerPost
import com.anymobile.domvet.ui.BaseViewModel
import com.anymobile.domvet.util.AppPreferences
import com.anymobile.domvet.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import splitties.experimental.ExperimentalSplittiesApi
import javax.inject.Inject

class ActiveTripsViewModel @Inject constructor(val getActivePassengerPost: GetActivePassengerPost,
                                               val deletePost: DeletePassengerPost,
                                               val finishPost: FinishPassengerPost) : BaseViewModel() {

    val activePostsResponse = SingleLiveEvent<ResultWrapper<List<PassengerPost>>>()
    val deletePostReponse = SingleLiveEvent<ResultWrapper<Int>>()
    val finishPostResponse = SingleLiveEvent<ResultWrapper<Int>>()

    @ExperimentalSplittiesApi
    fun getActivePosts() {
        activePostsResponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = getActivePassengerPost.execute(hashMapOf(
                Pair(Constants.TXT_TOKEN, AppPreferences.token),
                Pair(Constants.TXT_LANG, AppPreferences.language)))

            withContext(Dispatchers.Main) {
                activePostsResponse.value = response
            }
        }
    }

    @ExperimentalSplittiesApi
    fun deletePost(identifier: String, pos: Int) {
        deletePostReponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = deletePost.execute(hashMapOf(
                Pair(Constants.TXT_TOKEN, AppPreferences.token),
                Pair(Constants.TXT_ID, identifier),
                Pair(Constants.TXT_POSITION, pos)))

            withContext(Dispatchers.Main) {
                deletePostReponse.value = response
            }
        }
    }

    @ExperimentalSplittiesApi
    fun finishPost(identifier: String, pos: Int) {
        finishPostResponse.value = ResultWrapper.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            val response = finishPost.execute(hashMapOf(
                Pair(Constants.TXT_TOKEN, AppPreferences.token),
                Pair(Constants.TXT_ID, identifier),
                Pair(Constants.TXT_POSITION, pos)))

            withContext(Dispatchers.Main) {
                finishPostResponse.value = response
            }
        }
    }

}