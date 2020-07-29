package com.anymobile.domvet.ui.viewgroups

import android.view.View
import com.anymobile.domvet.R
import com.anymobile.domvet.domain.model.DriverPost
import com.anymobile.domvet.domain.model.PassengerPost
import com.anymobile.domvet.ui.interfaces.MyItemClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_passenger_post.view.*

class DriverPostItem(val post: DriverPost, val myItemClickListener: MyItemClickListener) :
    Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.date.text = post.departureDate
        viewHolder.itemView.from.text = post.from.regionName
        viewHolder.itemView.to.text = post.to.regionName
        viewHolder.itemView.price.text =
            viewHolder.itemView.context.getString(R.string.price_and_seats_format,
                                                  post.price.toString(), post.seat.toString())
//        viewHolder.itemView.seats.text = post.seat.toString()

        if (!post.remark.isBlank()) {
            viewHolder.itemView.note.visibility = View.VISIBLE
            viewHolder.itemView.note.text = post.remark
        } else {
            viewHolder.itemView.note.visibility = View.GONE
        }

    }

    override fun getLayout() = R.layout.item_passenger_post
}
