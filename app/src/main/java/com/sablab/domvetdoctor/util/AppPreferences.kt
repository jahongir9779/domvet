package com.sablab.domvetdoctor.util

/**
 * Created by jahon on 23-Apr-20
 */


import splitties.experimental.ExperimentalSplittiesApi
import splitties.preferences.Preferences

@ExperimentalSplittiesApi object AppPreferences : Preferences("myPrefs") {
    //    @ExperimentalSplittiesApi
//    var isUserLoggedIn by boolPref(false)
    @ExperimentalSplittiesApi
    var token by stringPref("")

    @ExperimentalSplittiesApi
    var language by stringPref("uz")

    @ExperimentalSplittiesApi
    var status by stringOrNullPref(null)

    @ExperimentalSplittiesApi
    var id by stringOrNullPref(null)

    @ExperimentalSplittiesApi
    var phoneNumber by stringPref("")

    @ExperimentalSplittiesApi
    var avatar by stringPref("")

    @ExperimentalSplittiesApi
    var birth_date by stringPref("")

    @ExperimentalSplittiesApi
    var firstName by stringPref("")

    @ExperimentalSplittiesApi
    var middleName by stringPref("")

    @ExperimentalSplittiesApi
    var lastName by stringPref("")

    @ExperimentalSplittiesApi
    var passport by stringOrNullPref(null)

    @ExperimentalSplittiesApi
    var passportRegistration by stringPref("")

    @ExperimentalSplittiesApi
    var email by  stringOrNullPref(null)

    @ExperimentalSplittiesApi
    var region_id by intPref(0)

    @ExperimentalSplittiesApi
    var city_id by intPref(0)

    @ExperimentalSplittiesApi
    var commission by  stringOrNullPref(null)

    @ExperimentalSplittiesApi
    var balance by intPref(0)


    @ExperimentalSplittiesApi
    var createdAt by stringOrNullPref(null)
}