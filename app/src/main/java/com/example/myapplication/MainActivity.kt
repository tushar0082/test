package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivtyViewModel: MainViewModel
    private lateinit var coinAdapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        mainActivtyViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recyclerCoin.layoutManager = LinearLayoutManager(this)


        lifecycleScope.launch {
            mainActivtyViewModel.getCoinData(this@MainActivity)

        }

        binding.buttonPanel.setOnClickListener{
            mainActivtyViewModel.getCoinData(this@MainActivity)
        }

        mainActivtyViewModel.assetList.observe(this, Observer { assetList ->
            // Handle the updated asset list here
            if (assetList.isNotEmpty()) {
                // For example, display a Toast with the name of the first asset
               coinAdapter=CoinAdapter(assetList)
                binding.recyclerCoin.adapter=coinAdapter
            }
        })



    }
}