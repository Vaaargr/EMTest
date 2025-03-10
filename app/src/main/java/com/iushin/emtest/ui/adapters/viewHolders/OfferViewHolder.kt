package com.iushin.emtest.ui.adapters.viewHolders

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.iushin.domain.models.Offer
import com.iushin.emtest.R
import com.iushin.emtest.databinding.OfferViewBinding

class OfferViewHolder(private val binding: OfferViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(offer: Offer) {
        binding.titleTv.text = offer.title
        if (offer.buttonText.isNullOrEmpty()){
            binding.titleTv.maxLines = 3
            binding.buttonTv.isVisible = false
        } else {
            binding.titleTv.maxLines = 2
            binding.buttonTv.text = offer.buttonText
        }
        binding.iconIv.setImageResource(
            when(offer.id){
                "near_vacancies" -> R.drawable.ic_new_editor
                "level_up_resume" -> R.drawable.ic_level_up
                "temporary_job" -> R.drawable.ic_temporary_job
                else -> R.drawable.ic_empty
            }
        )
    }
}