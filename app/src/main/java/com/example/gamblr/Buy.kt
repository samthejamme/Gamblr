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
        setContentView(R.layout.add_more_money)

        var balance = intent.getIntExtra(BUY, 0)
        binding.textViewMoreMoneyBalance.text = "$$balance"

        binding.buttonMoreMoneyAdd.setOnClickListener {
            balance++
            binding.textViewMoreMoneyBalance.text = "$$balance"
            // todo: give chance to add even more money
        }

        binding.floatingActionButtonAddMoneyClose.setOnClickListener {
            finish()
        }
    }
}