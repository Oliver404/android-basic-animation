package com.oliverbotello.example.basicanimation

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.annotation.AnimRes
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemClickListener {
    // Componets
    private lateinit var imgvwAnimated: ImageView
    private lateinit var spnrAnimation: AutoCompleteTextView
    private lateinit var btnPlay: Button
    // Vars
    @AnimRes private var animationSelected: Int = R.anim.jump

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Init components
        initView()
    }

    private fun initView() {
        // Get UI Elements
        imgvwAnimated = findViewById(R.id.img_animated)
        btnPlay = findViewById(R.id.btn_play)
        spnrAnimation = findViewById(R.id.autoCmlt_animations)
        // Create adapter with animation list
        val adptrAnimations: ArrayAdapter<*> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, resources.getStringArray(R.array.animations)
        )
        // Set listener for on select item
        spnrAnimation.onItemClickListener = this

        // Init dropdown
        adptrAnimations.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnrAnimation.setAdapter(adptrAnimations)
        // Select Jump animation as default
        spnrAnimation.setText(adptrAnimations.getItem(0).toString(), false)
        // Set on click listener to Play Button
        btnPlay.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // Init animation
        val jumpAnimation: Animation = AnimationUtils.loadAnimation(this, animationSelected)

        // Play animation
        imgvwAnimated.startAnimation(jumpAnimation)
    }
    
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        animationSelected = when(position) {
            1 -> R.anim.fade_in
            2 -> R.anim.fade_out
            3 -> R.anim.zoom_in
            4 -> R.anim.zoom_out
            5 -> R.anim.enter_up
            6 -> R.anim.exit_down
            else -> R.anim.jump
        }
    }
}