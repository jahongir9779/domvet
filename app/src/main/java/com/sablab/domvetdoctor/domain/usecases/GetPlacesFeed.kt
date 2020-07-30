package com.sablab.domvetdoctor.domain.usecases

import com.sablab.domvetdoctor.util.Constants
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.domain.model.Place
import com.sablab.domvetdoctor.domain.repository.PlaceRepository


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