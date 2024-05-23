package com.example.gamblr

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.AddMoreMoneyBinding


class Buy : AppCompatActivity() {
    companion object {
        val BUY = "More Money!!!"
    }
    lateinit var binding: AddMoreMoneyBinding
    var balance = 0
    var purcahses = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddMoreMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        balance = intent.getIntExtra(BUY, 0)
        binding.textViewScam.text = "$${purcahses}/$100"

        // todo: implement payment system that uses money
        binding.buttonGoldCoins.setOnClickListener {
            balance += 5
            purcahses += 9
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 10
            purcahses += 19
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 50
            purcahses += 29
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 70
            purcahses += 39
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 100
            purcahses += 49
        }
        binding.buttonGoldCoins.setOnClickListener {
            balance += 200
            purcahses += 99
        }
        binding.buttonScamCollector.setOnClickListener {
            if (purcahses % 100 == 0) {
                MainActivity.coins += 10
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Congratulations")
                alertDialogBuilder.setMessage("You just collected your free bonus coins!")

                alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> }
                alertDialogBuilder.show()
            }
        }
        binding.floatingActionButtonAddMoneyClose.setOnClickListener {
            MainActivity.coins += balance
            finish()
        }
    }
}