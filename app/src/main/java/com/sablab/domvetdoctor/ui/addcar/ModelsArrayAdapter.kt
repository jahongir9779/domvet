package com.sablab.domvetdoctor.ui.addcar
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import com.sablab.domvetdoctor.domain.model.CarModel
//import com.sablab.domvetdoctor.R
//import kotlinx.android.synthetic.main.item_car_model.view.*
//
//
//class ModelsArrayAdapter(val context: Context,
//                         val models: List<CarModel>) : BaseAdapter() {
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view: View
//        if (convertView == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item_car_model, parent, false)
//            view.textModel.text = models[position].name
////            view.itemParentView.setOnClickListener {
////                listnener.onClick(position)
////            }
//        } else {
//            view = convertView
//        }
//
//        return view
//    }
//
//    override fun getItem(position: Int) = models[position]
//    override fun getItemId(position: Int) = 0L
//    override fun getCount() = models.size
//
//}