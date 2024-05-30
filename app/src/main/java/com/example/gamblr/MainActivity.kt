package com.example.gamblr

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var spins = 0
    var bet = 0
    var earnings = 0
    private lateinit var binding : ActivityMainBinding
    private lateinit var icons : MutableList<Int>
    companion object {
        var coins = 10000
    }
    var didWin = false
    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        icons = mutableListOf(
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
            if (bet > 0 && coins - bet > 0){
                var x = (Math.random() * 13).toInt()
                var y = (Math.random() * 13).toInt()
                var z = (Math.random() * 13).toInt()
                // every fifth spin gets a 10% chance of a guaranteed win
                if (spins % 5 == 0) {
                    if ((Math.random() * 100 + 1).toInt() % 10 == 0) {
                        x = y
                        z = y
                    }
                }
                // todo: set the imageViews according to icons[x] etc.
                if((x == y && z == y) || (x == 0 || x == 5) && (y == 5 || y == 0) && (z == 0 || z == 5)) {
                    didWin = true
                }
                didWin(didWin)
            }
            else {
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Not Enough Coins!")
                alertDialogBuilder.setMessage("You need to either bet more coins or buy more coins to win!")

                alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> }
                alertDialogBuilder.show()
            }
        }

        binding.buttonBetAdd.setOnClickListener {
            if (coins < 100 || bet > coins) {
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Not Enough Coins!")
                alertDialogBuilder.setMessage("Go buy more coins to keep winning!")

                alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> }
                alertDialogBuilder.show()
            }
            else {
                bet += 100
            }
            binding.textViewBetCount.text = "$${bet}"
        }
        binding.buttonBetMinus.setOnClickListener {
            bet -= 100
            if (bet <= 100)
                bet = 0
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
    override fun onResume() {
        super.onResume()
        binding.textViewMoneyCounter.text = "$${coins}"
    }

    // todo: find a better way to tell them if they won or lost
    // todo: make the toast pop up after the spin animation is finished
    @SuppressLint("SetTextI18n")
    fun didWin(boolean: Boolean) {
        val aba = (Math.random() * 5).toInt()
        if (boolean) {
            coins += bet
            earnings += bet
            didWin = false
            binding.textViewMoneyCounter.text = "$${coins}"
//            binding.textViewBetCount.text = "0"
            binding.textViewMoneyWon.text = "Total Winnings: $${earnings}"
            when(aba) {
                1 -> Toast.makeText(this, "JACKPOT!!!", Toast.LENGTH_SHORT).show()
                0 -> Toast.makeText(this, "Nice!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "You're on fire!", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "WOW!", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this, "Alan Wood's got nothing on you!", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            coins -= bet
            binding.textViewMoneyCounter.text = "$${coins}"
            when(aba) {
                1 -> Toast.makeText(this, "Keep trying!", Toast.LENGTH_SHORT).show()
                0 -> Toast.makeText(this, "99% of gamblers quit just before they hit big!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "So close!", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "Don't give up! You'll get it next time!", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this, "You don't know how far you go if you don't try! Keep going!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}