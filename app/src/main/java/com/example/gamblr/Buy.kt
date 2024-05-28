package com.example.gamblr

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.AddMoreMoneyBinding


class Buy : AppCompatActivity() {
    companion object {
        val BUY = "More Money!!!"
    }
    lateinit var binding: AddMoreMoneyBinding
    var balance = 0
    var purcahses = MainActivity.purcahses
    var cardCash = MainActivity.money.toInt()
    var x = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddMoreMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        balance = intent.getIntExtra(BUY, 0)
        binding.textViewScamCounter.text = "$${purcahses}/$100"
        binding.textViewDebtCard.text = "$${cardCash} left in card"

        binding.buttonGoldCoins.setOnClickListener {
            addMoney(5, 9, 10)
        }
        binding.buttonGoldStack.setOnClickListener {
            addMoney(10, 19, 20)
        }
        binding.buttonGoldPile.setOnClickListener {
            addMoney(50, 29, 30)
        }
        binding.buttonGoldBundle.setOnClickListener {
            addMoney(70, 39, 40)
        }
        binding.buttonGoldBowl.setOnClickListener {
            addMoney(100, 49, 50)
        }
        binding.buttonGoldVault.setOnClickListener {
            addMoney(200, 99, 100)
        }
        binding.buttonScamCollector.setOnClickListener {
            if (purcahses > 100) {
                MainActivity.coins += 10
                Toast.makeText(this, "Congratulations! You just collected your free bonus coins!", Toast.LENGTH_SHORT).show()
                purcahses -= 100
                binding.textViewScamCounter.text = "$${purcahses}/$100"
            }
        }
        binding.floatingActionButtonAddMoneyClose.setOnClickListener {
            MainActivity.coins = balance
            MainActivity.purcahses = purcahses
            MainActivity.money = cardCash + "$x".substring("$x".length - 2).toDouble() * 0.01
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    fun addMoney(bal : Int, pur : Int, mon : Int) {
        if (cardCash - mon >= 0) {
            balance += bal
            purcahses += pur
            cardCash -= mon
            x += 99
        }
        else {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Not Enough Funds")
            alertDialogBuilder.setMessage("You need more funds to keep buying!")

            alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> }
            alertDialogBuilder.show()
        }
        binding.textViewScamCounter.text = "$${purcahses}/$100"
        binding.textViewDebtCard.text = "$${cardCash}.${"$x".substring("$x".length - 2)} left in card"
    }
}