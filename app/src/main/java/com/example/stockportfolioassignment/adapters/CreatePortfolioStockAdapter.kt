package com.example.stockportfolioassignment.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.stockportfolioassignment.R
import com.example.stockportfolioassignment.dummyNetworkCall.DummyResponseModel
import kotlinx.android.synthetic.main.stock_item.view.*

class CreatePortfolioStockAdapter(var stocksList: List<DummyResponseModel>, private val listener: StocksSelectedInterface) :
    RecyclerView.Adapter<CreatePortfolioStockAdapter.CreatePortfolioStockViewHolder>() {

    class CreatePortfolioStockViewHolder(view: View) : RecyclerView.ViewHolder(view)
    private var countOfStocksSelected = 10

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreatePortfolioStockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stock_item, parent, false)
        return CreatePortfolioStockViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreatePortfolioStockViewHolder, position: Int) {
        val currentElement = stocksList[position]

        val currentChangeAndPercentChange = "${currentElement.change} (${currentElement.percentageChange}%)"

        holder.itemView.tvStocksSymbol.text = currentElement.symbol
        holder.itemView.tvCurrentDetail.text = currentChangeAndPercentChange

        stocksSelected(holder, currentElement)
    }

    override fun getItemCount(): Int {
        return stocksList.size
    }

    private fun stocksSelected(holder: CreatePortfolioStockViewHolder, currentElement: DummyResponseModel){
        holder.itemView.radioGroupBuyOrSell.setOnCheckedChangeListener { _, checkedId ->
            val checkedButton = holder.itemView.findViewById<RadioButton>(checkedId)
            if (countOfStocksSelected>0) {
                if (checkedButton.text == "Buy"){
                    countOfStocksSelected--
                    listener.addStockInBuy(currentElement.symbol)
                }else if (checkedButton.text == "Sell"){
                    countOfStocksSelected--
                    listener.addStockInSell(currentElement.symbol)
                }
            }else {
                Log.d("Adapter", "You cannot select anymore")
            }
        }
    }

    interface StocksSelectedInterface{
        fun addStockInBuy(symbol: String?)
        fun addStockInSell(symbol: String?)
    }
}