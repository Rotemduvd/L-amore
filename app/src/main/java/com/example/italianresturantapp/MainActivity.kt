package com.example.italianresturantapp

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.Animation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pastaImage = findViewById<ImageView>(R.id.pastaImage)
        val title = findViewById<TextView>(R.id.title)
        val tagline = findViewById<TextView>(R.id.tagline)
        val buttons = findViewById<LinearLayout>(R.id.buttonRow)

        title.alpha = 0f
        tagline.alpha = 0f
        buttons.alpha = 0f

        // Load animations
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.pasta_slide)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in)

        // Start pasta slide-in
        pastaImage.startAnimation(slideIn)

        slideIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                title.startAnimation(fadeIn)
                tagline.startAnimation(fadeIn)
                buttons.startAnimation(fadeIn)

                title.alpha = 1f
                tagline.alpha = 1f
                buttons.alpha = 1f
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        // Dish items

        // Salad
        val salad = findViewById<View>(R.id.item_salad)
        salad.findViewById<TextView>(R.id.dish_title).text = getString(R.string.salad_title)
        salad.findViewById<TextView>(R.id.dish_description).text = getString(R.string.salad_desc)
        salad.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.greek_salad)
        salad.findViewById<TextView>(R.id.dish_price).text = getString(R.string.salad_price)

        // Pasta Rosé
        val pastaRose = findViewById<View>(R.id.item_pasta_rose)
        pastaRose.findViewById<TextView>(R.id.dish_title).text = getString(R.string.pasta_rose_title)
        pastaRose.findViewById<TextView>(R.id.dish_description).text = getString(R.string.pasta_rose_desc)
        pastaRose.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.pasta_rose)
        pastaRose.findViewById<TextView>(R.id.dish_price).text = getString(R.string.pasta_rose_price)

        // Pasta Pomadoro
        val pastaPomadoro = findViewById<View>(R.id.item_pasta_pomadoro)
        pastaPomadoro.findViewById<TextView>(R.id.dish_title).text = getString(R.string.pasta_pomadoro_title)
        pastaPomadoro.findViewById<TextView>(R.id.dish_description).text = getString(R.string.pasta_pomadoro_desc)
        pastaPomadoro.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.pasta_tomato_and_basil)
        pastaPomadoro.findViewById<TextView>(R.id.dish_price).text = getString(R.string.pasta_pomadoro_price)

        // Pizza Pomadoro
        val pizzaPomadoro = findViewById<View>(R.id.item_pizza_pomadoro)
        pizzaPomadoro.findViewById<TextView>(R.id.dish_title).text = getString(R.string.pizza_pomadoro_title)
        pizzaPomadoro.findViewById<TextView>(R.id.dish_description).text = getString(R.string.pizza_pomadoro_desc)
        pizzaPomadoro.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.pizza_pomadoro)
        pizzaPomadoro.findViewById<TextView>(R.id.dish_price).text = getString(R.string.pizza_pomadoro_price)

        // Beer
        val beer = findViewById<View>(R.id.item_beer)
        beer.findViewById<TextView>(R.id.dish_title).text = getString(R.string.beer_title)
        beer.findViewById<TextView>(R.id.dish_description).text = getString(R.string.beer_desc)
        beer.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.beer)
        beer.findViewById<TextView>(R.id.dish_price).text = getString(R.string.beer_price)

        // Coca-Cola
        val coke = findViewById<View>(R.id.item_coke)
        coke.findViewById<TextView>(R.id.dish_title).text = getString(R.string.coke_title)
        coke.findViewById<TextView>(R.id.dish_description).text = getString(R.string.coke_desc)
        coke.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.coke)
        coke.findViewById<TextView>(R.id.dish_price).text = getString(R.string.coke_price)

        val scrollView = findViewById<ScrollView>(R.id.main_scroll)
        val menuSection = findViewById<View>(R.id.section_menu)
        val contactSection = findViewById<View>(R.id.section_contact)

        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnContact = findViewById<Button>(R.id.btnContact)

        btnMenu.setOnClickListener {
            scrollView.post {
                scrollView.smoothScrollTo(0, menuSection.top)
            }
        }

        btnContact.setOnClickListener {
            scrollView.post {
                scrollView.smoothScrollTo(0, contactSection.top)
            }
        }
    }
}