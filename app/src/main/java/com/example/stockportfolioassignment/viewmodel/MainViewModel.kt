package com.example.stockportfolioassignment.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.stockportfolioassignment.dummyNetworkCall.DummyResponseModel
import com.example.stockportfolioassignment.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel @ViewModelInject constructor(
    repository: MainRepository
) : ViewModel(){

    private val _stockDetails = repository.dataForPortfolioCreation()
        .asLiveData(viewModelScope.coroutineContext + Dispatchers.IO)

    val stockDetails: LiveData<List<DummyResponseModel>>
    get() = _stockDetails

}