package com.sablab.domvetdoctor.ui.viewgroups

import com.sablab.domvetdoctor.domain.model.CarDetails
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.interfaces.MyItemClickListener
import com.sablab.domvetdoctor.util.loadImageUrl
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_car.view.*

class CarItemView(val car: CarDetails, val onItemClickListener: MyItemClickListener) : Item() {


    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.carAvatar.loadImageUrl(car.image!!.link!!)
        viewHolder.itemView.plateNumber.text = car.carNumber
//        viewHolder.itemView.plateNumber.setTextFuture(
//            PrecomputedTextCompat.getTextFuture(car.carNumber!!,
//                                                viewHolder.itemView.plateNumber.textMetricsParamsCompat,
//                                                null)
//        )
//        viewHolder.itemView.plateNumber.text = car.carNumber
        viewHolder.itemView.carYear.text = car.carYear.toString()
        viewHolder.itemView.carModel.text = car.carModel!!.name.toString()
        viewHolder.itemView.carAction.setOnClickListener {
            onItemClickListener.onClick(position, it)
        }

        if (car.def != null && car.def!!) {
            viewHolder.itemView.cardParent.setBackgroundResource(R.drawable.stroke_primary)
        }

    }

    override fun getLayout() = R.layout.item_car

}
