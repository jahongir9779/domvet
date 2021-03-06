package com.sablab.domvetdoctor.ui.viewgroups

import android.view.View
import android.widget.ProgressBar
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.domain.model.PassengerPost
import com.sablab.domvetdoctor.ui.interfaces.IOnPostActionListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_doc_call.view.*


class ItemDocCall(var post: PassengerPost, var onPostActionListener: IOnPostActionListener) :
    Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
//        viewHolder.itemView.date.text = post.departureDate
//        viewHolder.itemView.from.text = post.from.regionName
//        viewHolder.itemView.to.text = post.to.regionName
//        viewHolder.itemView.price.text = post.price.toString()
//
//
//
//
//
//        if (!post.remark.isBlank()) {
//            viewHolder.itemView.note.visibility = View.VISIBLE
//            viewHolder.itemView.note.text = post.remark
//        } else {
//            viewHolder.itemView.note.visibility = View.GONE
//        }
//
//
//        if (viewHolder.itemView.findViewById<View>(R.id.progress) != null) {
//            viewHolder.itemView.cl_parent.removeView(viewHolder.itemView.findViewById<View>(R.id.progress))
//            viewHolder.itemView.done.visibility = View.VISIBLE
//            viewHolder.itemView.cancel.visibility = View.VISIBLE
//            viewHolder.itemView.edit.visibility = View.VISIBLE
//        }
//
//
//        viewHolder.itemView.done.setOnClickListener {
//            val progressBar = ProgressBar(viewHolder.itemView.context)
//            progressBar.id = R.id.progress
//            progressBar.layoutParams = viewHolder.itemView.done.layoutParams
//            progressBar.setPadding(20, 20, 20, 20)
//            viewHolder.itemView.cl_parent.addView(progressBar)
//            viewHolder.itemView.done.visibility = View.INVISIBLE
//            viewHolder.itemView.cancel.visibility = View.INVISIBLE
//            viewHolder.itemView.edit.visibility = View.INVISIBLE
//
//            onPostActionListener.onDoneClick(position, post, viewHolder.itemView.cl_parent)
//        }
//        viewHolder.itemView.edit.setOnClickListener {
//            onPostActionListener.onEditClick(post)
//        }
//
//
//        viewHolder.itemView.cancel.setOnClickListener {
//            val progressBar = ProgressBar(viewHolder.itemView.context)
//            progressBar.id = R.id.progress
//            progressBar.layoutParams = viewHolder.itemView.cancel.layoutParams
//            progressBar.setPadding(20, 20, 20, 20)
//            viewHolder.itemView.cl_parent.addView(progressBar)
//            viewHolder.itemView.done.visibility = View.INVISIBLE
//            viewHolder.itemView.cancel.visibility = View.INVISIBLE
//            viewHolder.itemView.edit.visibility = View.INVISIBLE
//            onPostActionListener.onCancelClick(position, post, viewHolder.itemView.cl_parent)
//        }

    }

    override fun getLayout() = R.layout.item_doc_call
}
