package com.example.italianresturantapp

import android.app.AlertDialog
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
import android.graphics.Rect
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //WELCOME SCREEN ANIMATION

        val pastaImage = findViewById<ImageView>(R.id.pastaImage)
        val title = findViewById<TextView>(R.id.title)
        val tagline = findViewById<TextView>(R.id.tagline)
        val buttons = findViewById<LinearLayout>(R.id.buttonRow)

        title.alpha = 0f
        tagline.alpha = 0f
        buttons.alpha = 0f

        //load anim
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.pasta_slide)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in)

        //start first ani
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


        // WELCOME BUTTONS ANIMATION AND PRODUCTIVITY
        val scrollView = findViewById<ScrollView>(R.id.main_scroll)
        val menuSection = findViewById<View>(R.id.section_menu)
        val contactSection = findViewById<View>(R.id.section_contact)

        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnContact = findViewById<Button>(R.id.btnContact)

        btnMenu.setOnClickListener {
            it.animate()
                .scaleX(1.1f).scaleY(1.1f)
                .setDuration(100)
                .withEndAction {
                    it.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction {
                        scrollView.post {
                            scrollView.smoothScrollTo(0, menuSection.top)
                        }
                    }
                }
        }

        btnContact.setOnClickListener {
            it.animate()
                .scaleX(1.1f).scaleY(1.1f)
                .setDuration(100)
                .withEndAction {
                    it.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction {
                        scrollView.post {
                            scrollView.smoothScrollTo(0, contactSection.top)
                        }
                    }
                }
        }


        // DISH ITEMS

        // salad
        val salad = findViewById<View>(R.id.item_salad)
        salad.findViewById<TextView>(R.id.dish_title).text = getString(R.string.salad_title)
        salad.findViewById<TextView>(R.id.dish_description).text = getString(R.string.salad_desc)
        salad.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.greek_salad)
        salad.findViewById<TextView>(R.id.dish_price).text = getString(R.string.salad_price)

        // pasta Rose
        val pastaRose = findViewById<View>(R.id.item_pasta_rose)
        pastaRose.findViewById<TextView>(R.id.dish_title).text = getString(R.string.pasta_rose_title)
        pastaRose.findViewById<TextView>(R.id.dish_description).text = getString(R.string.pasta_rose_desc)
        pastaRose.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.pasta_rose)
        pastaRose.findViewById<TextView>(R.id.dish_price).text = getString(R.string.pasta_rose_price)

        // pasta Pomadoro
        val pastaPomadoro = findViewById<View>(R.id.item_pasta_pomadoro)
        pastaPomadoro.findViewById<TextView>(R.id.dish_title).text = getString(R.string.pasta_pomadoro_title)
        pastaPomadoro.findViewById<TextView>(R.id.dish_description).text = getString(R.string.pasta_pomadoro_desc)
        pastaPomadoro.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.pasta_tomato_and_basil)
        pastaPomadoro.findViewById<TextView>(R.id.dish_price).text = getString(R.string.pasta_pomadoro_price)

        // pizza Pomadoro
        val pizzaPomadoro = findViewById<View>(R.id.item_pizza_pomadoro)
        pizzaPomadoro.findViewById<TextView>(R.id.dish_title).text = getString(R.string.pizza_pomadoro_title)
        pizzaPomadoro.findViewById<TextView>(R.id.dish_description).text = getString(R.string.pizza_pomadoro_desc)
        pizzaPomadoro.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.pizza_pomadoro)
        pizzaPomadoro.findViewById<TextView>(R.id.dish_price).text = getString(R.string.pizza_pomadoro_price)

        // beer
        val beer = findViewById<View>(R.id.item_beer)
        beer.findViewById<TextView>(R.id.dish_title).text = getString(R.string.beer_title)
        beer.findViewById<TextView>(R.id.dish_description).text = getString(R.string.beer_desc)
        beer.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.beer)
        beer.findViewById<TextView>(R.id.dish_price).text = getString(R.string.beer_price)

        // coke
        val coke = findViewById<View>(R.id.item_coke)
        coke.findViewById<TextView>(R.id.dish_title).text = getString(R.string.coke_title)
        coke.findViewById<TextView>(R.id.dish_description).text = getString(R.string.coke_desc)
        coke.findViewById<ImageView>(R.id.dish_image).setImageResource(R.drawable.coke)
        coke.findViewById<TextView>(R.id.dish_price).text = getString(R.string.coke_price)

        //CONTACT SCROLL ANIMATIONS
        val contactScroll = findViewById<ScrollView>(R.id.contact_scroll)
        val storyH = findViewById<TextView>(R.id.our_story)
        val whereH = findViewById<TextView>(R.id.where)
        val reserveH = findViewById<TextView>(R.id.reserve)

        var contactAnimated = false

        contactScroll.viewTreeObserver.addOnScrollChangedListener {
            val visibleRect = Rect()
            contactScroll.getHitRect(visibleRect)

            if (storyH.getLocalVisibleRect(visibleRect) && !contactAnimated) {
                contactAnimated = true
                val animation = AnimationUtils.loadAnimation(this, R.anim.fall)
                storyH.startAnimation(animation)
                whereH.startAnimation(animation)
                reserveH.startAnimation(animation)
            }
        }

        //CONTACT SEAT SEEK

        val seatsSeekBar = findViewById<SeekBar>(R.id.seats_seekbar)
        val seatsCount = findViewById<TextView>(R.id.seats_count)

        seatsSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seatsCount.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //CONTACT CONFIRMATION ALERT
        val reserveButton = findViewById<Button>(R.id.btn_reserve)
        val radioGroup = findViewById<RadioGroup>(R.id.payment_radio_group)
        val timePicker = findViewById<TimePicker>(R.id.time_spinner)
        val veganSwitch = findViewById<SwitchCompat>(R.id.vegan_switch)

        reserveButton.setOnClickListener {
            val seats = seatsSeekBar.progress
            val paymentMethodId = radioGroup.checkedRadioButtonId
            val paymentMethod = findViewById<RadioButton>(paymentMethodId)?.text ?: "Not selected"
            val hour = timePicker.hour
            val minute = timePicker.minute
            val isVegan = veganSwitch.isChecked

            val message = """
                You are reserving $seats seat(s).
                Payment: $paymentMethod
                Time: ${String.format(Locale.getDefault(),"%02d:%02d", hour, minute)}
                Vegan Meal: ${if (isVegan) "Yes" else "No"}
            """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("Confirm Reservation")
                .setMessage(message)
                .setPositiveButton("Confirm") { _, _ ->
                    Toast.makeText(this, "Reservation saved!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }


    }
}