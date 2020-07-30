package com.sablab.domvetdoctor.ui.viewgroups

import android.graphics.Color
import com.sablab.domvetdoctor.domain.model.Place
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.addpost.destinations.DestFeedPresenter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_place_autocomplete.view.*

class PlaceFeedItemView(val place: Place,
                        val presenter: DestFeedPresenter) : Item() {


    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.placeName.text = place.name
        viewHolder.itemView.regionName.text = place.regionName

        if (position == 0) viewHolder.itemView.autocompleteItemparent.setBackgroundColor(Color.parseColor("#33008577"))

        viewHolder.itemView.autocompleteItemparent.setOnClickListener {
            presenter.dispatchItemClick(this)
        }
    }

    override fun getLayout() = R.layout.item_place_autocomplete

}
