package com.example.italianresturantapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

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
    }
}