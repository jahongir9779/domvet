package com.sablab.domvetdoctor.ui.viewgroups

import com.sablab.domvetdoctor.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

class LoadingItemSmall : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

    override fun getLayout()= R.layout.item_loading_small

}
