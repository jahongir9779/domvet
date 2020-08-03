package com.sablab.domvetdoctor.ui.selectcity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_list_row.view.*
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.models.City

class CityAdapter(private val onSelectAction: (City) -> Unit) : ListAdapter<City, CityAdapter.ViewHolder>(City.DIFF_UTILL), Filterable {
    var mInflater: LayoutInflater? = null
    var data: List<City> = emptyList()

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults? {
                val charString = charSequence.toString()
                val contactListFiltered = if (charString.isEmpty()) {
                    data.toList()
                } else {
                    data.toList().filter { it.cityName.toLowerCase().contains(charString.toLowerCase()) || it.citySlug.toLowerCase().contains(charString.toLowerCase()) }
                }
                val filterResults = FilterResults()
                filterResults.values = contactListFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
                val contactListFiltered = filterResults.values as List<City>
                submitList(contactListFiltered.toMutableList())
            }
        }
    }

    fun setDatas(obj: List<City>) {
        this.data = obj.toList()
        submitList(obj)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.context)
        }
        return ViewHolder(mInflater!!.inflate(R.layout.city_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var city: City? = null

        fun onBind(obj: City) {
            city = obj
            itemView.tv_city_name.text = city?.cityName
            itemView.setOnClickListener {
                city?.let(onSelectAction)
            }
        }

    }

}