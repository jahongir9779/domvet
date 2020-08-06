package com.sablab.domvetdoctor.ui.registration.docsandcertificates

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.docsexample.DocsPhotoExampleActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationActivity
import com.sablab.domvetdoctor.ui.registration.RegistrationViewModel
import com.sablab.domvetdoctor.ui.viewgroups.ItemAdditionalDocPhoto
import com.sablab.domvetdoctor.util.ADDITIONAL0
import com.sablab.domvetdoctor.util.PhotoAttachHelper
import com.sablab.domvetdoctor.util.updateNextButtonState
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_docs_and_certificates.*
import splitties.fragments.start
import javax.inject.Inject


//@FlowPreview
//@ExperimentalCoroutinesApi
class DocsAndCertificatesFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) :
    Fragment(R.layout.fragment_docs_and_certificates) {


    private val activityViewModel: RegistrationViewModel by activityViewModels {
        viewModelFactory
    }
    private val actViewModel: RegistrationViewModel by activityViewModels()

    private val viewModel: DocsAndCertificatesViewModel by viewModels {
        viewModelFactory
    }

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.cancelActiveJobs()
    }

//DO NOT FORGET!!!    (appCtx as App).releaseRegistrationComponent()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        intiViews()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        navController = findNavController()

//        login.isEnabled = true


        attachListeners()
        subscribeObservers()
    }


    val adapter = GroupAdapter<GroupieViewHolder>()
    private fun intiViews() {
        rv_photo_grid.adapter = adapter
        if (adapter.itemCount == 0) {
            adapter.add(ItemAdditionalDocPhoto(null, { position ->
                PhotoAttachHelper.openCameraOrStorageDialog(
                    requireActivity(),
                    ("4${position}").toInt())
            }, { position ->
                                                   if (adapter.itemCount >= 6) {
                                                       (adapter.getItem(
                                                           adapter.itemCount - 1) as ItemAdditionalDocPhoto).bitmap =
                                                           null
                                                   } else {
                                                       adapter.remove(adapter.getItem(position))
//                                                       adapter.notifyDataSetChanged()
                                                   }
                                                   actViewModel.removeDocAtPos(position)
                                               }))
        }
    }

    private fun attachListeners() {
        cardDocsPhotoExample.setOnClickListener {
            start<DocsPhotoExampleActivity> { }
        }

        btn_next.setOnClickListener {
            navController.navigate(R.id.action_navDocsAndCertificatesFragment_to_navBiographyFragment)
        }


        cardImage1.setOnClickListener {
            PhotoAttachHelper.openCameraOrStorageDialog(requireActivity(), ADDITIONAL0)
        }

    }

    private fun subscribeObservers() {
        actViewModel.additionalImages.observe(viewLifecycleOwner, Observer { bitmapList ->
            if (bitmapList.size > 0) {

                bitmapList.forEachIndexed { index, bitmap ->
                    validateBitmap(index, bitmap)
                }
                adapter.notifyDataSetChanged()
                icRemove.visibility = View.VISIBLE
                icAdd.visibility = View.INVISIBLE
                frame1.visibility = View.INVISIBLE
                rv_photo_grid.visibility = View.VISIBLE

            } else {
                rv_photo_grid.visibility = View.INVISIBLE
                frame1.visibility = View.VISIBLE
                icRemove.visibility = View.INVISIBLE
                icAdd.visibility = View.VISIBLE
            }
            btn_next.updateNextButtonState(bitmapList.isNotEmpty())
        })

    }

    private fun validateBitmap(index: Int, bitmap: Bitmap) {
        if (index < adapter.itemCount - 1) {

            (adapter.getItem(index) as ItemAdditionalDocPhoto).bitmap = bitmap
        } else if (index == adapter.itemCount - 1) {
            adapter.add(adapter.itemCount - 1,
                        ItemAdditionalDocPhoto(bitmap,
                                               { position ->
                                                   PhotoAttachHelper.openCameraOrStorageDialog(
                                                       requireActivity(),
                                                       ("4${position}").toInt())
                                               }, { position ->

                                                   if ((adapter.getItem(adapter.itemCount - 1) as ItemAdditionalDocPhoto).bitmap != null) {
                                                       (adapter.getItem(
                                                           adapter.itemCount - 1) as ItemAdditionalDocPhoto).bitmap =
                                                           null
                                                   } else {
                                                       adapter.remove(adapter.getItem(position))
                                                   }
                                                   actViewModel.removeDocAtPos(position)
                                               }))


            if (index == 5) {
                adapter.remove(adapter.getItem(adapter.itemCount - 1))
            }

        }
    }

    override fun onResume() {
        super.onResume()
        (activity as RegistrationActivity).setRegProgress(80)
    }


}




