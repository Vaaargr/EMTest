package com.iushin.emtest.ui.adapters.viewHolders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.iushin.domain.models.Vacancy
import com.iushin.emtest.R
import com.iushin.emtest.databinding.VacancyViewBinding
import com.iushin.emtest.ui.adapters.clickListeners.OnHeartVacancyClickListener

class VacancyViewHolder(
    private val binding: VacancyViewBinding,
    private val context: Context,
    private val clickListener: OnHeartVacancyClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(vacancy: Vacancy) {
        binding.currentlyViewingTv.text =
            context.resources.getQuantityString(
                R.plurals.looking_number,
                vacancy.lookingNumber,
                vacancy.lookingNumber
            )

        binding.chosenIv.setImageResource(
            if (vacancy.isFavorite) R.drawable.ic_heart_fill else R.drawable.ic_chosen
        )

        binding.vacancyTitle.text = vacancy.title
        binding.salaryTv.text = vacancy.salaryFull
        binding.townTv.text = vacancy.town
        binding.companyNameTv.text = vacancy.company
        binding.experienceTv.text = vacancy.experiencePreviewText
        binding.publishedDateTv.text = getPublishedDate(vacancy.publishedDate)

        binding.chosenIv.setOnClickListener {
            vacancy.isFavorite = !vacancy.isFavorite
            binding.chosenIv.setImageResource(
                if (vacancy.isFavorite) R.drawable.ic_heart_fill else R.drawable.ic_chosen
            )
            clickListener.onHeartVacancyClick(vacancy)
        }
    }

    private fun getPublishedDate(pDate: String): String {
        val months = context.resources.getStringArray(R.array.months)

        val date = pDate.split('-')
        val month = months[date[1].toInt() - 1]
        return "Опубликовано ${date[2].toInt()} $month"
    }
}