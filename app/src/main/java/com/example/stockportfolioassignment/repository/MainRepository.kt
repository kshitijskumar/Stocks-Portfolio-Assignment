package com.example.stockportfolioassignment.repository

import android.util.Log
import com.example.stockportfolioassignment.dummyData.DummyDataSource
import com.example.stockportfolioassignment.dummyNetworkCall.DummyResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val dummyDataSource: DummyDataSource
) {

    fun dataForPortfolioCreation() = flow<List<DummyResponseModel>> {
        val listOfStocks = mutableListOf<DummyResponseModel>()

        Log.d("MainRepoThread", "Current Thread ${Thread.currentThread().name}")
        withContext(Dispatchers.IO) {
            Log.d("MainRepoThread", "Current Thread ${Thread.currentThread().name}")
            try {
                withTimeout(5000L) {
                    val mapOfStocks = dummyDataSource.currentMapOfStocks
                    mapOfStocks.keys.forEach { key ->
                        val currentElement = mapOfStocks[key]
                        Log.d("RepoTry", "${currentElement?.change}")
                        listOfStocks.add(
                            DummyResponseModel(
                                key,
                                currentElement?.currentPrice,
                                currentElement?.change,
                                currentElement?.percentageChange
                            )
                        )
                    }
                    Log.d("MainRepoEmit", "Size of list in MR is ${listOfStocks.size}")
                    emit(listOfStocks)
                }
            } catch (e: Exception) {
                Log.d("RepoCatch", e.message.toString())
            }
        }
    }
}