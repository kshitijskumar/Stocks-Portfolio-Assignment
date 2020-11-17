package com.example.stockportfolioassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stockportfolioassignment.R
import com.example.stockportfolioassignment.adapters.CreatePortfolioStockAdapter
import com.example.stockportfolioassignment.viewmodel.MainViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_create_portfolio.*

@AndroidEntryPoint
class CreatePortfolio : AppCompatActivity() , CreatePortfolioStockAdapter.StocksSelectedInterface {

    private val viewModel: MainViewModel by viewModels()
    private val adapter by lazy { CreatePortfolioStockAdapter(listOf(),this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portfolio)

        rvStocks.layoutManager = LinearLayoutManager(this)
        rvStocks.adapter = adapter
        viewModel.stockDetails.observe(this, {
            it?.let {
                if (it.isNotEmpty()){
                    adapter.stocksList = it
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    override fun addStockInBuy(symbol: String?) {
        val chip = LayoutInflater.from(this).inflate(R.layout.chip_element, chipGrpBuy, false) as Chip
        chip.text = symbol
        chipGrpBuy.addView(chip)
        chip.setOnCloseIconClickListener {
            chipGrpBuy.removeView(chip)
        }
    }

    override fun addStockInSell(symbol: String?) {
        val chip = LayoutInflater.from(this).inflate(R.layout.chip_element, chipGrpSell, false) as Chip
        chip.text = symbol
        chipGrpSell.addView(chip)
    }
}