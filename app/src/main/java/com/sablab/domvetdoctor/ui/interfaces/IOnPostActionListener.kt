package com.sablab.domvetdoctor.ui.interfaces

import android.view.View
import com.sablab.domvetdoctor.domain.model.PassengerPost

interface IOnPostActionListener {
    fun onEditClick(post: PassengerPost)
    fun onCancelClick(position: Int, post: PassengerPost, parentView: View)
    fun onDoneClick(position: Int, post: PassengerPost, parentView: View)
}