package com.anymobile.domvet.domain.usecases

import com.anymobile.domvet.util.Constants
import com.anymobile.domvet.util.ResultWrapper
import com.anymobile.domvet.domain.model.Place
import com.anymobile.domvet.domain.repository.PlaceRepository


/** User Login Use Case
 *
 */
class GetPlacesFeed(val repository: PlaceRepository) :
    UseCaseWithParams<HashMap<String, String>, ResultWrapper<List<Place>>>() {

    override suspend fun buildUseCase(params: HashMap<String, String>): ResultWrapper<List<Place>> {
        return repository.getPlacesAutocomplete(params[Constants.TXT_TOKEN]!!,
                                                params[Constants.TXT_LANG]!!,
                                                params[Constants.TXT_PLACE]!!)
    }
}