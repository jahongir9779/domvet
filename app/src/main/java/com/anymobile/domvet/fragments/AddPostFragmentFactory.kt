package com.anymobile.domvet.fragments

//import com.codingwithmitch.openapi.di.main.MainScope
//import com.codingwithmitch.openapi.ui.main.account.AccountFragment
//import com.codingwithmitch.openapi.ui.main.account.ChangePasswordFragment
//import com.codingwithmitch.openapi.ui.main.account.UpdateAccountFragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.anymobile.domvet.di.addPost.AddPostScope
import com.anymobile.domvet.ui.addpost.carandtext.CarAndTextFragment
import com.anymobile.domvet.ui.addpost.datetime.DateAndTimeFragment
import com.anymobile.domvet.ui.addpost.destinations.DestinationsFragment
import com.anymobile.domvet.ui.addpost.preview.PreviewFragment
import com.anymobile.domvet.ui.addpost.priceandseat.PriceAndSeatFragment
import javax.inject.Inject

@AddPostScope
class AddPostFragmentFactory @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            DestinationsFragment::class.java.name -> {
                DestinationsFragment(viewModelFactory)
            }
            PriceAndSeatFragment::class.java.name -> {
                PriceAndSeatFragment(viewModelFactory)
            }
            PreviewFragment::class.java.name -> {
                PreviewFragment(viewModelFactory)
            }
            DateAndTimeFragment::class.java.name -> {
                DateAndTimeFragment(viewModelFactory)
            }
            CarAndTextFragment::class.java.name -> {
                CarAndTextFragment(viewModelFactory)
            }
            else -> {
                DestinationsFragment(viewModelFactory)
            }
        }


}