package com.example.gamblr

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.AddMoreMoneyBinding


class Buy : AppCompatActivity() {
    companion object {
        const val BUY = "More Money!!!"
    }
    private lateinit var binding: AddMoreMoneyBinding
    private var balance = 0
    private var purcahses = 0.0
    private var cardCash = 1000
    private var x = 1000000000

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddMoreMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        balance = intent.getIntExtra(BUY, 0)
        binding.textViewScamCounter.text = "$${purcahses}/$100.00"
        binding.textViewDebtCard.text = "$${cardCash}.${"$x".substring("$x".length - 2)} left in card"

        binding.buttonGoldCoins.setOnClickListener {
            addMoney(5, 9.99, 10)
        }
        binding.buttonGoldStack.setOnClickListener {
            addMoney(10, 19.99, 20)
        }
        binding.buttonGoldPile.setOnClickListener {
            addMoney(50, 29.99, 30)
        }
        binding.buttonGoldBundle.setOnClickListener {
            addMoney(70, 39.99, 40)
        }
        binding.buttonGoldBowl.setOnClickListener {
            addMoney(100, 49.99, 50)
        }
        binding.buttonGoldVault.setOnClickListener {
            addMoney(200, 99.99, 100)
        }
        binding.buttonScamCollector.setOnClickListener {
            if (purcahses > 100) {
                MainActivity.coins += 10
                Toast.makeText(this, "Congratulations! You just collected your free bonus coins!", Toast.LENGTH_SHORT).show()
                purcahses -= 100
                val asdjfkl = purcahses.toString()
                binding.textViewScamCounter.text = "$${asdjfkl.substring(0, asdjfkl.indexOf("."))}${asdjfkl.substring(asdjfkl.indexOf("."), asdjfkl.indexOf(".") + 3)}/$100.00"
            }
        }
        binding.floatingActionButtonAddMoneyClose.setOnClickListener {
            MainActivity.coins = balance
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    fun addMoney(bal : Int, pur : Double, mon : Int) {
        if (cardCash - mon >= 0) {
            balance += bal
            purcahses += pur
            cardCash -= mon
            x -= 99
        }
        else {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Not Enough Funds")
            alertDialogBuilder.setMessage("You need more funds to keep buying!")

            alertDialogBuilder.setPositiveButton(android.R.string.yes) { _, _ -> }
            alertDialogBuilder.show()
        }
        val asdjfkl = purcahses.toString()
        binding.textViewScamCounter.text = "$${asdjfkl.substring(0, asdjfkl.indexOf("."))}${asdjfkl.substring(asdjfkl.indexOf("."), asdjfkl.indexOf(".") + 3)}/$100.00"
        binding.textViewDebtCard.text = "$${cardCash}.${"$x".substring("$x".length - 2)} left in card"
    }
}