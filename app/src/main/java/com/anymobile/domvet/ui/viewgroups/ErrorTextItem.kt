package com.anymobile.domvet.ui.viewgroups

import com.anymobile.domvet.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_error_text.view.*

class ErrorTextItem(val errorMessage: String?) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.errorMessage.text = errorMessage
    }

    override fun getLayout() = R.layout.item_error_text

}
