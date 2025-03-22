package com.iushin.emtest.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.api.FavoriteVacancyInteractor
import com.iushin.domain.api.GetDateInteractor
import com.iushin.domain.impl.CheckVacancyUseCase
import com.iushin.domain.models.Response
import com.iushin.domain.models.Vacancy
import com.iushin.emtest.presentation.state.ShowState
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getDateInteractor: GetDateInteractor,
    private val favoriteVacancyInteractor: FavoriteVacancyInteractor,
    private val checkVacancyUseCase: CheckVacancyUseCase
) : ViewModel() {

    private val responseLiveData = MutableLiveData<Response>()

    private val countLiveData = MutableLiveData<Int>()

    fun observeResponse(): LiveData<Response> = responseLiveData

    fun observeCounter(): LiveData<Int> = countLiveData

    private fun setResponse(response: Response) {
        responseLiveData.postValue(response)
    }

    private fun setCount(count: Int) {
        countLiveData.postValue(count)
    }

    private val showStateLiveData = MutableLiveData<ShowState>()

    fun observeState(): LiveData<ShowState> = showStateLiveData

    private fun setState(state: ShowState) {
        showStateLiveData.postValue(state)
    }

    private fun setPreview() {
        val offers = responseLiveData.value!!.offers
        val vacancies = responseLiveData.value!!.vacancies.subList(0, 3)
        val count = responseLiveData.value!!.vacancies.size - 3
        setState(ShowState.Preview(Response(offers, vacancies), count))
    }

    private fun setFullShow() {
        setState(ShowState.FullShow(responseLiveData.value!!))
    }

    fun getDate() {
        viewModelScope.launch {
            val response = getDateInteractor.getDate()

            response.vacancies.forEach {
                if (it.isFavorite) {
                    if (!checkVacancyUseCase.checkVacancy(it.id)) {
                        favoriteVacancyInteractor.addFavoriteVacancy(it)
                    }
                } else {
                    if (checkVacancyUseCase.checkVacancy(it.id)) {
                        it.isFavorite = true
                    }
                }
            }

            var count = 0

            response.vacancies.forEach {
                if (it.isFavorite) count++
            }

            setCount(count)
            setResponse(response)
        }
    }

    fun onBackArrowClick() {
        setPreview()
    }

    fun onFullShowButtonClick() {
        setFullShow()
    }

    fun onHeartClicked(vacancy: Vacancy) {
        responseLiveData.value!!.vacancies.find { it.id == vacancy.id }!!.isFavorite =
            vacancy.isFavorite

        viewModelScope.launch {
            if (vacancy.isFavorite) {
                setCount(favoriteVacancyInteractor.addFavoriteVacancy(vacancy = vacancy))
            } else {
                setCount(favoriteVacancyInteractor.deleteFavoriteVacancy(vacancyId = vacancy.id))
            }
        }
    }
}