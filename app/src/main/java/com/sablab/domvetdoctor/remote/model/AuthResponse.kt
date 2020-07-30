package com.sablab.domvetdoctor.remote.model

import com.sablab.domvetdoctor.domain.model.UserCredentials

/**
 * Created by jahon on 12-Apr-20
 */
data class AuthResponse(val code: Int? = null,
                        val message: String? = null,
                        val data: UserCredentials? = null)

