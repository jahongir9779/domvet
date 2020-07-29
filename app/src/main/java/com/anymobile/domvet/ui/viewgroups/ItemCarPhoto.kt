package com.anymobile.domvet.ui.viewgroups

import com.anymobile.domvet.domain.model.PhotoBody
import com.anymobile.domvet.R
import com.anymobile.domvet.util.loadImageUrl
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_car_photo.view.*

class ItemCarPhoto(val photoBody: PhotoBody, val deleteClickListener: OnItemClickListener) :
    Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.iv_delete.setOnClickListener {
            deleteClickListener.onItemClick(this, it)
        }
        viewHolder.itemView.iv_car_photo.loadImageUrl(photoBody.link!!)
    }

    override fun getLayout() = R.layout.item_car_photo
}
