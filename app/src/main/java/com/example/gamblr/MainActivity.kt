package com.example.gamblr

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.gamblr.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button;
import android.widget.ImageView
class MainActivity : AppCompatActivity() {
    var wins = 0
    var spins = 0
    var bet = 0
    var coins = 0
    private lateinit var binding : ActivityMainBinding

    private lateinit var button: Button
    private lateinit var animation: Animation
    private lateinit var imageView: ImageView

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val icons: MutableList<Int> = mutableListOf(
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
            // every fifth spin gets a 10% chance of a guaranteed win
            if(spins % 5 == 0) {
                if((Math.random() * 100 + 1).toInt() % 10 == 0) {
                    x = y
                    z = y
                }
            }
            button = button.findViewById(R.id.button_anim)
            animation = AnimationUtils.loadAnimation(this, R.anim.slidedown)
            imageView = imageView.findViewById(R.id.test)
            imageView.startAnimation(animation)

            imageView.startAnimation(animation)

            if(x == y && z == y) {
                wins++
            }
            if((x == 0 || x == 5) && (y == 5 || y == 0) && (z == 0 || z == 5)) {
                wins++
            }
        }

        // todo: create bet setonclicklistener func

        binding.floatingActionButtonBuyMoney.setOnClickListener {
            val context = binding.root.context
            val intent = Intent(context, Buy::class.java)
            intent.putExtra(Buy.BUY, coins)
            context.startActivity(intent)
        }

    }
}