package com.sablab.domvetdoctor.models

import androidx.recyclerview.widget.DiffUtil

data class AnimalDisease(val diseaseId: String) {
    companion object {
        val DIFF_UTILL = object : DiffUtil.ItemCallback<AnimalDisease>() {
            override fun areItemsTheSame(oldItem: AnimalDisease, newItem: AnimalDisease) =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: AnimalDisease,
                newItem: AnimalDisease
            ) = oldItem.diseaseId == newItem.diseaseId
        }
    }
}