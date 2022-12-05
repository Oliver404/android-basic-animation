package com.oliverbotello.example.basicanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Componets
    private lateinit var imgvwAnimated: ImageView
    private lateinit var btnPlay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Init components
        initView()
    }

    private fun initView() {
        imgvwAnimated = findViewById(R.id.img_animated)
        btnPlay = findViewById(R.id.btn_play)

        btnPlay.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val jumpAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.exit_down)

        imgvwAnimated.startAnimation(jumpAnimation)
    }
}