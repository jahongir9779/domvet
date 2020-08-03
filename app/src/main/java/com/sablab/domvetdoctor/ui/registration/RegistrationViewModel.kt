package com.sablab.domvetdoctor.ui.registration

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns
import androidx.lifecycle.viewModelScope

import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.commons.Event
import com.sablab.domvetdoctor.models.Photo
import com.sablab.domvetdoctor.models.PhotoConfig
import com.sablab.domvetdoctor.models.network.NAnimal
import com.sablab.domvetdoctor.models.network.NDisease
import com.sablab.domvetdoctor.models.network.NReason
import com.sablab.domvetdoctor.ui.BaseViewModel
import com.sablab.domvetdoctor.util.ErrorWrapper
import com.sablab.domvetdoctor.util.ResultWrapper
import com.sablab.domvetdoctor.util.toByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegistrationViewModel @Inject constructor() : BaseViewModel() {




}