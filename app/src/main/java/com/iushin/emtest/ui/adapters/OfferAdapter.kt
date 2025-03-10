package com.iushin.emtest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iushin.domain.models.Offer
import com.iushin.emtest.databinding.OfferViewBinding
import com.iushin.emtest.ui.adapters.clickListeners.OnOfferClickListener
import com.iushin.emtest.ui.adapters.viewHolders.OfferViewHolder

class OfferAdapter(private val clickListener: OnOfferClickListener) :
    RecyclerView.Adapter<OfferViewHolder>() {
    private val offers = ArrayList<Offer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding = OfferViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return offers.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(offers[position])
        holder.itemView.setOnClickListener { clickListener.onOfferClick(offers[position]) }
    }

    fun addOffers(inputOffers: List<Offer>){
        offers.clear()
        offers.addAll(inputOffers)
        notifyDataSetChanged()
    }
}