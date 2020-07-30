package com.sablab.domvetdoctor.util

import com.sablab.domvetdoctor.util.AutoCompleteManager

/**
 * Created by jahon on 22-Jul-20
 */
fun buildAutoCompleteManager(lambda: AutoCompleteManager.Builder.() -> Unit) =
    AutoCompleteManager.Builder().apply(lambda).create()