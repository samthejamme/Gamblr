package com.example.gamblr

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.PopupWindow

class MainActivity : AppCompatActivity() {
    var wins = 0
    var spins = 0
    var bet = 0
    var coins = 0
    private lateinit var binding : ActivityMainBinding
    private lateinit var icons : List<Int>
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // todo: implement a bunch of icons using photoIDs

        binding.buttonSpin.setOnClickListener {
            // todo: to be implemented
            // todo: randomly choose which icons get chosen
            // todo: keep track of spins so each fifth gets 10% chance of win
        }

        binding.floatingActionButtonBuyMoney.setOnClickListener {
            val context = binding.root.context
            val intent = Intent(context, Buy::class.java)
            intent.putExtra(Buy.BUY, coins)
            context.startActivity(intent)
        }
    }
}