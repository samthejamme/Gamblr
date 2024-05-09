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

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddMoreMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var balance = intent.getIntExtra(BUY, 0)
        binding.textViewMoreMoneyBalance.text = "$$balance"

        binding.buttonMoreMoneyAdd.setOnClickListener {
            balance += 100
            binding.textViewMoreMoneyBalance.text = "$$balance"
        }

        binding.floatingActionButtonAddMoneyClose.setOnClickListener {
            MainActivity.coins = balance
            MainActivity.reload()
            finish()
        }
    }
}