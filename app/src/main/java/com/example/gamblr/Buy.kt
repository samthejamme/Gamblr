package com.example.gamblr

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.AddMoreMoneyBinding


class Buy : AppCompatActivity() {
    companion object {
        val BUY = "More Money!!!"
    }
    lateinit var binding: AddMoreMoneyBinding
    var balance = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddMoreMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        balance = intent.getIntExtra(BUY, 0)

        // todo: implement payment system that uses money
        binding.buttonGoldCoins.setOnClickListener {
            balance += 5
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 10
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 50
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 70
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 100
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 200
        }
    }
}