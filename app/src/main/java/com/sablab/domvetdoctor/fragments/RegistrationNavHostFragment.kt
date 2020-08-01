package com.sablab.domvetdoctor.fragments

import android.content.Context
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity

/**
 * Created by jahon on 20-Apr-20
 */
class RegistrationNavHostFragment : NavHostFragment() {

    override fun onAttach(context: Context) {
        childFragmentManager.fragmentFactory =
            (activity as RegistrationActivity).fragmentFactory
        super.onAttach(context)
    }

    companion object {
        const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        @JvmStatic
        fun create(
            @NavigationRes graphId: Int = 0
        ): RegistrationNavHostFragment {
            var bundle: Bundle? = null
            if (graphId != 0) {
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result =
                RegistrationNavHostFragment()
            if (bundle != null) {
                result.arguments = bundle
            }
            return result
        }
    }

}