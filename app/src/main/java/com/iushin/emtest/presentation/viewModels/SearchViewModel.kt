package com.iushin.emtest.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.api.GetDateInteractor
import com.iushin.domain.api.SearchFragmentDatabaseInteractor
import com.iushin.domain.models.Response
import com.iushin.domain.models.Vacancy
import com.iushin.emtest.presentation.state.ShowState
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getDateInteractor: GetDateInteractor,
    private val databaseInteractor: SearchFragmentDatabaseInteractor
) : ViewModel() {

    private val responseLiveData = MutableLiveData<Response>()

    fun observeResponse(): LiveData<Response> = responseLiveData

    private fun setResponse(response: Response) {
        responseLiveData.postValue(response)
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
                    if (!databaseInteractor.checkVacancy(it.id)) {
                        databaseInteractor.addFavoriteVacancy(it)
                    }
                } else {
                    if (databaseInteractor.checkVacancy(it.id)) {
                        it.isFavorite = true
                    }
                }
            }

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
                databaseInteractor.addFavoriteVacancy(vacancy)
            } else {
                databaseInteractor.deleteFavoriteVacancy(vacancy.id)
            }
        }
    }
}