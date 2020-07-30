package com.sablab.domvetdoctor.ui.interfaces

interface IOnPlaceSearchQueryListener {
    fun onQuery(query: CharSequence?, isFrom: Boolean = true, isSelectedFromFeed:Boolean=false)
}