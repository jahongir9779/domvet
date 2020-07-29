package com.anymobile.domvet.remote.model

import com.anymobile.domvet.domain.model.PhotoBody

/**
 * Created by jahon on 12-Apr-20
 */
data class PhotoUploadResponse(val code: Int? = null,
                               val message: String? = null,
                               val data: PhotoBody? = null)