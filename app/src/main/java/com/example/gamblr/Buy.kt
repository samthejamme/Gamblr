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
    var cardCash = 1000.00

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddMoreMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        balance = intent.getIntExtra(BUY, 0)
        binding.textViewScamCounter.text = "$${purcahses}/$100"
        binding.textViewDebtCard.text = "$${cardCash} left in card"

        binding.buttonGoldCoins.setOnClickListener {
            addMoney(5, 9, 9.99)
        }
        binding.buttonGoldCoins.setOnClickListener {
            addMoney(10, 19, 19.99)
        }
        binding.buttonGoldCoins.setOnClickListener {
            addMoney(50, 29, 29.99)
        }
        binding.buttonGoldCoins.setOnClickListener {
            addMoney(70, 39, 39.99)
        }
        binding.buttonGoldCoins.setOnClickListener {
            addMoney(100, 49, 49.99)
        }
        binding.buttonGoldCoins.setOnClickListener {
            addMoney(200, 99, 99.99)
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

    @SuppressLint("SetTextI18n")
    fun addMoney(bal : Int, pur : Int, mon : Double) {
        if (cardCash - mon >= 0) {
            balance += bal
            purcahses += pur
            cardCash -= mon
        }
        else {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Not Enough Funds")
            alertDialogBuilder.setMessage("You need more funds to keep buying!")

            alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> }
            alertDialogBuilder.show()
        }
        binding.textViewScamCounter.text = "$${purcahses}/$100"
        binding.textViewDebtCard.text = "$${cardCash} left in card"
    }
}