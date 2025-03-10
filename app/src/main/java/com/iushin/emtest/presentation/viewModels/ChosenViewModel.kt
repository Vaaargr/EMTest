package com.iushin.emtest.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.api.ChosenFragmentInteractor
import com.iushin.domain.models.Vacancy
import kotlinx.coroutines.launch

class ChosenViewModel(private val interactor: ChosenFragmentInteractor) : ViewModel() {

    private val vacanciesLiveData = MutableLiveData<List<Vacancy>>()

    fun observeVacancies(): LiveData<List<Vacancy>> = vacanciesLiveData

    private fun setVacancies(vacancies: List<Vacancy>) {
        vacanciesLiveData.postValue(vacancies)
    }

    fun getVacancies() {
        viewModelScope.launch {
            setVacancies(interactor.getVacancies())
        }
    }

    fun onHeartClicked(vacancy: Vacancy) {
        vacanciesLiveData.value!!.find { it.id == vacancy.id }!!.isFavorite = vacancy.isFavorite

        viewModelScope.launch {
            if (vacancy.isFavorite) {
                interactor.addFavoriteVacancy(vacancy)
            } else {
                interactor.deleteFavoriteVacancy(vacancy.id)
            }
        }
    }
}