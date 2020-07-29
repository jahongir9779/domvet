package com.anymobile.domvet.util

import com.anymobile.domvet.util.AutoCompleteManager

/**
 * Created by jahon on 22-Jul-20
 */
fun buildAutoCompleteManager(lambda: AutoCompleteManager.Builder.() -> Unit) =
    AutoCompleteManager.Builder().apply(lambda).create()