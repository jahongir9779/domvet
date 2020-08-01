package com.sablab.domvetdoctor.ui.viewgroups

import android.view.View
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.ui.interfaces.IOnPostActionListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_doc_call.view.*

class HistoryPostItem(var post: PassengerPost, var onPostActionListener: IOnPostActionListener) :
    Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
//        viewHolder.itemView.date.text = post.departureDate
//        viewHolder.itemView.from.text = post.from.regionName
//        viewHolder.itemView.to.text = post.to.regionName
//        viewHolder.itemView.price.text =
//            viewHolder.itemView.context.getString(R.string.price_and_seats_format,
//                                                  post.price.toString(), post.seat.toString())
////        viewHolder.itemView.seats.text = post.seat.toString()
//
//        if (!post.remark.isBlank()) {
//            viewHolder.itemView.note.visibility = View.VISIBLE
//            viewHolder.itemView.note.text = post.remark
//        } else {
//            viewHolder.itemView.note.visibility = View.GONE
//        }


    }

    override fun getLayout() = R.layout.item_history_post
}
