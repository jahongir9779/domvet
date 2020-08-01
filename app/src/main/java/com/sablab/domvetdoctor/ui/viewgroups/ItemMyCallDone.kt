package com.sablab.domvetdoctor.ui.viewgroups

import android.view.View
import android.widget.ProgressBar
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.ui.interfaces.IOnPostActionListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_doc_call.view.*


class ItemMyCallDone(var post: PassengerPost, var onPostActionListener: IOnPostActionListener) :
    Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

    }

    override fun getLayout() = R.layout.item_my_call_done
}
