package com.example.gamblr

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var earnings = 0
    var didWin = false
    var spins = 0
    var bet = 0
    var coins = 0
    private lateinit var binding : ActivityMainBinding
    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val icons : MutableList<Int> = mutableListOf(
            // the rock
            R.drawable._85db39af6bdf1f0d607584bd8f105d3,
            R.drawable.apple_transparent_background_free_png,
            R.drawable.bok_choy_chinese_png_file,
            R.drawable.diamond_1857733_1280,
            R.drawable.isolated_orange_fruit_on_transparent_background_free_png,
            // the rock
            R.drawable.unnamed,
            // steamboat willie
            R.drawable.dfpxkwi_b4f81f10_90ef_4121_97d3_8d83325d0616,
            R.drawable.ramen_with_egg_japanese_noodle_food_colorful_illustration_on_transparent_background_png,
            // banana
            R.drawable._168365c6246ccdd05f0834a5a54fe8a,
            // jackpot
            R.drawable._36050,
            R.drawable.pngtree_isolated_cat_on_white_background_png_image_7094927,
            R.drawable.gamblr)

        binding.buttonSpin.setOnClickListener {
            var x = (Math.random() * 13).toInt()
            var y = (Math.random() * 13).toInt()
            var z = (Math.random() * 13).toInt()
            // every fifth spin gets a 3% chance of a guaranteed win
            if(spins % 5 == 0) {
                if((Math.random() * 100 + 1).toInt() % 30 == 0) {
                    x = y
                    z = y
                }
            }
            // todo: set the imageViews according to icons[x] etc.
            if(x == y && z == y) {
                didWin = true
            }
            // this is to make sure rock and the Rock are counted as the same
            if((x == 0 || x == 5) && (y == 5 || y == 0) && (z == 0 || z == 5)) {
                didWin = true
            }
        }

        binding.buttonBetAdd.setOnClickListener {
            if (coins < 100) {
                Toast.makeText(this, "Not enough coins! Go buy more to keep winning!", Toast.LENGTH_LONG).show()
            }
            else {
                bet += 100
            }
            binding.textViewBetCount.text = "$${bet}"
        }
        binding.buttonBetMinus.setOnClickListener {
            bet -= 100
            binding.textViewBetCount.text = "$${bet}"
        }

        binding.floatingActionButtonBuyMoney.setOnClickListener {
            val context = binding.root.context
            val intent = Intent(context, Buy::class.java)
            intent.putExtra(Buy.BUY, coins)
            context.startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    fun didWin(boolean: Boolean) {
        if (boolean) {
            earnings += bet
            coins += bet
            didWin = false
            binding.textViewMoneyCounter.text = "$${coins}"
//            binding.textViewBetCount.text = "0"
            binding.textViewMoneyWon.text = "$${earnings}"
        }
        else {
            coins -= bet
            binding.textViewMoneyCounter.text = "$${coins}"
        }
    }
}