package com.example.stockportfolioassignment.dummyNetworkCall

data class DummyResponseModel(
    val symbol: String?,
    val currentPrice: String?,
    val change: String?,
    val percentageChange: String?
)