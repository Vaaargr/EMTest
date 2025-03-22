package com.iushin.emtest.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.api.FavoriteVacancyInteractor
import com.iushin.domain.impl.GetFavoriteVacanciesUseCase
import com.iushin.domain.models.Vacancy
import kotlinx.coroutines.launch

class ChosenViewModel(
    private val favoriteVacancyInteractor: FavoriteVacancyInteractor,
    private val getFavoriteVacanciesUseCase: GetFavoriteVacanciesUseCase
) : ViewModel() {

    private val vacanciesLiveData = MutableLiveData<List<Vacancy>>()

    private val countLiveData = MutableLiveData<Int>()

    fun observeCounter(): LiveData<Int> = countLiveData

    private fun setCount(count: Int) {
        countLiveData.postValue(count)
    }

    fun observeVacancies(): LiveData<List<Vacancy>> = vacanciesLiveData

    private fun setVacancies(vacancies: List<Vacancy>) {
        vacanciesLiveData.postValue(vacancies)
    }

    fun getVacancies() {
        viewModelScope.launch {
            setVacancies(getFavoriteVacanciesUseCase.getVacancies())
        }
    }

    fun onHeartClicked(vacancy: Vacancy) {
        val vacancyNew = ArrayList(vacanciesLiveData.value!!)
        vacancyNew.remove(vacancy)
        setVacancies(vacancyNew)

        viewModelScope.launch {
            if (vacancy.isFavorite) {
                setCount(favoriteVacancyInteractor.addFavoriteVacancy(vacancy = vacancy))
            } else {
                setCount(favoriteVacancyInteractor.deleteFavoriteVacancy(vacancyId = vacancy.id))
            }
        }
    }
}