package com.sablab.domvetdoctor.ui.viewgroups

import android.graphics.Bitmap
import android.view.View
import com.sablab.domvetdoctor.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_additional_doc_photo.view.*

class ItemAdditionalDocPhoto(var bitmap: Bitmap?,
                             val onClick: (position: Int) -> Unit,
                             val onDelete: (position: Int) -> Unit) : Item() {


    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        if (bitmap != null) {
            viewHolder.itemView.ivDelete.visibility = View.VISIBLE
            viewHolder.itemView.iv.visibility = View.VISIBLE
            viewHolder.itemView.iv.setImageBitmap(bitmap)
        } else {
            viewHolder.itemView.iv.visibility = View.INVISIBLE
            viewHolder.itemView.ivDelete.visibility = View.INVISIBLE
        }

        viewHolder.itemView.card.setOnClickListener {
            onClick(position)
        }

        viewHolder.itemView.ivDelete.setOnClickListener {
            onDelete(position)
        }


    }

    override fun getLayout() = R.layout.item_additional_doc_photo

}
