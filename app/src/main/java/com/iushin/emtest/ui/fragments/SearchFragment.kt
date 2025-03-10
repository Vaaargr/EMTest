package com.iushin.emtest.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iushin.domain.models.Offer
import com.iushin.domain.models.Vacancy
import com.iushin.emtest.R
import com.iushin.emtest.databinding.FragmentSearchBinding
import com.iushin.emtest.presentation.state.ShowState
import com.iushin.emtest.presentation.viewModels.SearchViewModel
import com.iushin.emtest.ui.adapters.OfferAdapter
import com.iushin.emtest.ui.adapters.VacancyAdapter
import com.iushin.emtest.ui.adapters.clickListeners.OnHeartVacancyClickListener
import com.iushin.emtest.ui.adapters.clickListeners.OnOfferClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(), OnOfferClickListener, OnHeartVacancyClickListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<SearchViewModel>()

    private val offersAdapter = OfferAdapter(this)
    private val vacanciesAdapter = VacancyAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel.getDate()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.offersRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.offersRv.adapter = offersAdapter

        binding.vacanciesRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.vacanciesRv.adapter = vacanciesAdapter

        viewModel.observeResponse().observe(viewLifecycleOwner) {
            viewModel.onBackArrowClick()
        }

        viewModel.observeState().observe(viewLifecycleOwner) { state ->
            offersAdapter.addOffers(state.response.offers)
            vacanciesAdapter.addVacancies(state.response.vacancies)
            when (state) {
                is ShowState.FullShow -> {
                    binding.vacanciesTw.text = resources.getQuantityString(
                        R.plurals.vacancies_show,
                        state.fullResponse.vacancies.size,
                        state.fullResponse.vacancies.size
                    )
                    binding.previewGroup.isVisible = false
                    binding.fullShowGroup.isVisible = true
                }

                is ShowState.Preview -> {
                    binding.previewGroup.isVisible = true
                    binding.fullShowGroup.isVisible = false
                    val buttonText =
                        resources.getQuantityString(R.plurals.vacancies, state.count, state.count)
                    binding.showAllVacanciesBt.text = buttonText
                }
            }
        }

        binding.backButton.setOnClickListener {
            viewModel.onBackArrowClick()
        }

        binding.showAllVacanciesBt.setOnClickListener {
            viewModel.onFullShowButtonClick()
        }
    }

    override fun onOfferClick(offer: Offer) {
        val address = Uri.parse(offer.link)
        val intent = Intent(Intent.ACTION_VIEW, address)
        startActivity(intent)
    }

    override fun onHeartVacancyClick(vacancy: Vacancy) {
        viewModel.onHeartClicked(vacancy)
    }
}