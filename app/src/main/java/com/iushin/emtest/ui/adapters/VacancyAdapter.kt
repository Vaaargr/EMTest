package com.iushin.emtest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iushin.domain.models.Vacancy
import com.iushin.emtest.databinding.VacancyViewBinding
import com.iushin.emtest.ui.adapters.clickListeners.OnHeartVacancyClickListener
import com.iushin.emtest.ui.adapters.viewHolders.VacancyViewHolder

class VacancyAdapter(private val clickListener: OnHeartVacancyClickListener) :
    RecyclerView.Adapter<VacancyViewHolder>() {
    private val vacancies = ArrayList<Vacancy>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val binding = VacancyViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VacancyViewHolder(binding, parent.context, clickListener)
    }

    override fun getItemCount(): Int {
        return vacancies.size
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(vacancies[position])
    }

    fun addVacancies(inputVacancies: List<Vacancy>) {
        vacancies.clear()
        vacancies.addAll(inputVacancies)
        notifyDataSetChanged()
    }
}