package com.sablab.domvetdoctor.ui.registration.addyourphoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.add_doctor_cal_photo.view.*
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.models.Photo

class PhotoAdapter(
    private val deletePhotoAction: (Photo) -> Unit
) :
    ListAdapter<Photo, PhotoAdapter.ViewHolder>(Photo.DIFF_UTILL) {

    var mInflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mInflater == null)
            mInflater = LayoutInflater.from(parent.context)

        return ViewHolder(mInflater!!.inflate(R.layout.add_doctor_cal_photo, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.onRecycler()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item: Photo? = null
        fun onBind(i: Photo) {

            item = i
            Glide.with(itemView).load(item?.image).into(itemView.iv)

            itemView.btn_delete.setOnClickListener {
                item?.let { deletePhotoAction.invoke(it) }
            }
        }

        fun onRecycler() {
            itemView.iv.setImageDrawable(null)
        }

    }
}
