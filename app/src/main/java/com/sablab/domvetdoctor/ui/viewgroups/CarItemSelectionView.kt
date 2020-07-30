package com.sablab.domvetdoctor.ui.viewgroups

import androidx.core.content.ContextCompat
import com.sablab.domvetdoctor.domain.model.CarDetails
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.interfaces.MyItemClickListener
import com.sablab.domvetdoctor.util.loadImageUrl
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_car_selection.view.*

class CarItemSelectionView(val car: CarDetails, val onItemClickListener: MyItemClickListener) : Item() {


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
        viewHolder.itemView.carModel.text = car.carModel.toString()
        viewHolder.itemView.cardParent.setOnClickListener {
            onItemClickListener.onClick(position, it)
        }

        if (car.def != null && car.def!!) {
            viewHolder.itemView.cardParent.setCardBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context,
                                                                                         R.color.orange))
        }

    }

    override fun getLayout() = R.layout.item_car_selection

}
