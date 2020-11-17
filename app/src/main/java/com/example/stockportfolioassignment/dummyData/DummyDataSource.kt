package com.example.stockportfolioassignment.dummyData

class DummyDataSource {
//    val listOfSymbols = listOf("BPCL", "IOC", "TATAMOTORS", "HDFCLIFE", "SUNPHARMA", "COALINDIA", "GAIL", "TATASTEEL", "HDFCBANK",
//                                "INFY", "BHARTIARTL", "UPL", "SBILIFE", "LT", "MARUTI", "TCS", "ONGC", "ITC", "WIPRO", "NTPC",
//                                "KOTAKBANK", "ASIANPAINT", "DRREDDY", "BRITANNIA", "DIVISLAB")

    val currentMapOfStocks = HashMap<String, DummyDataModel>()

    init {
        currentMapOfStocks["BPCL"] = DummyDataModel("414.45", "20.45", "5.19")
        currentMapOfStocks["IOC"] = DummyDataModel("87", "2.25", "2.65")
        currentMapOfStocks["TATAMOTORS"] = DummyDataModel("148.45", "2.10", "1.43")
        currentMapOfStocks["HDFCLIFE"] = DummyDataModel("636.55", "8.05", "1.28")
        currentMapOfStocks["SUNPHARMA"] = DummyDataModel("514.00", "5.55", "1.09")
        currentMapOfStocks["COALINDIA"] = DummyDataModel("127.10", "1.20", "0.95")
        currentMapOfStocks["GAIL"] = DummyDataModel("93.65", "0.85", "0.92")
        currentMapOfStocks["TATASTEEL"] = DummyDataModel("490.95", "4.40", "0.90")
        currentMapOfStocks["HDFCBANK"] = DummyDataModel("1371", "12.20", "0.90")
        currentMapOfStocks["INFY"] = DummyDataModel("1134", "9.80", "0.87")
        currentMapOfStocks["BHARTIARTL"] = DummyDataModel("479.90", "4.15", "0.87")
        currentMapOfStocks["UPL"] = DummyDataModel("429.00", "3.65", "0.86")
        currentMapOfStocks["SBILIFE"] = DummyDataModel("839.00", "7.15", "0.86")
        currentMapOfStocks["LT"] = DummyDataModel("1058.85", "7.35", "0.70")
        currentMapOfStocks["MARUTI"] = DummyDataModel("6852.00", "42.75", "0.63")
        currentMapOfStocks["TCS"] = DummyDataModel("2673.25", "16.40", "0.62")
        currentMapOfStocks["ONGC"] = DummyDataModel("72.60", "0.45", "0.62")
        currentMapOfStocks["ITC"] = DummyDataModel("188.20", "1.10", "0.59")
        currentMapOfStocks["WIPRO"] = DummyDataModel("345.90", "1.75", "0.51")
        currentMapOfStocks["NTPC"] = DummyDataModel("91.90", "0.45", "0.49")
        currentMapOfStocks["KOTAKBANK"] = DummyDataModel("1770.90", "7.60", "0.43")
        currentMapOfStocks["ASIANPAINT"] = DummyDataModel("2189.00", "9.05", "0.42")
        currentMapOfStocks["DRREDDY"] = DummyDataModel("4875.60", "18.70", "0.39")
        currentMapOfStocks["BRITANNIA"] = DummyDataModel("3527.00", "12.55", "0.36")
        currentMapOfStocks["DIVISLAB"] = DummyDataModel("3444.00", "11.05", "0.32")
    }
}