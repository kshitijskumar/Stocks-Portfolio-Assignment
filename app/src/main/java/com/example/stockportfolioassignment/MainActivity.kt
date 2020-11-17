package com.example.stockportfolioassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.stockportfolioassignment.ui.CreatePortfolio
import com.example.stockportfolioassignment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreatePortfolio.setOnClickListener {
            val intent = Intent(this, CreatePortfolio::class.java)
            startActivity(intent)
        }

        viewModel.stockDetails.observe(this, {
            Log.d("MainActivity", "Size of the list in MA is ${it.size}")
            Log.d("MainActivity", "List is $it")
        })
    }
}