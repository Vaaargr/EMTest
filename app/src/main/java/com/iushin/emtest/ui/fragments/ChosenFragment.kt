package com.iushin.emtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iushin.domain.models.Vacancy
import com.iushin.emtest.R
import com.iushin.emtest.databinding.FragmentChosenBinding
import com.iushin.emtest.presentation.viewModels.ChosenViewModel
import com.iushin.emtest.ui.adapters.VacancyAdapter
import com.iushin.emtest.ui.adapters.clickListeners.OnHeartVacancyClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChosenFragment : Fragment(), OnHeartVacancyClickListener {
    private var _binding: FragmentChosenBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ChosenViewModel>()

    private val vacanciesAdapter = VacancyAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChosenBinding.inflate(inflater, container, false)
        viewModel.getVacancies()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chosenVacanciesRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.chosenVacanciesRv.adapter = vacanciesAdapter

        viewModel.observeVacancies().observe(viewLifecycleOwner){
            vacanciesAdapter.addVacancies(it)
            binding.vacanciesCount.text = resources.getQuantityString(
                R.plurals.vacancies_show,
                it.size,
                it.size
            )
        }
    }

    override fun onHeartVacancyClick(vacancy: Vacancy) {
        viewModel.onHeartClicked(vacancy)
    }
}