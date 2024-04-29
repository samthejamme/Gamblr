package com.example.gamblr

import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.ActivityMainBinding
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var wins = 0
    var spins = 0
    var bet = 0
    var coins = 0
    private lateinit var binding : ActivityMainBinding
    private lateinit var icons : List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // todo: implement a bunch of icons using photoIDs

        binding.button_spin.setOnClickListener {
            // todo: to be implemented
            // todo: randomly choose which icons get chosen
            // todo: keep track of spins so each fifth gets 10% chance of win
        }

        binding.
    }
}