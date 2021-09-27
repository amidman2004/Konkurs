package com.example.myapplicationconkurstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.vse_shabloni.*

class vse_shabloni : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vse_shabloni)
        j1 = 0
        shb1.setOnTouchListener(object: OnSwipeTouchListener(this){
            override fun onSwipeLeft() {
                delete.isVisible = true
                delete.isClickable = true
                change.isVisible = true
                change.isClickable = true
            }
            override fun onSwipeRight() {
                delete.isVisible = false
                delete.isClickable = false
                change.isVisible = false
                change.isClickable = false
            }
        })
        delete.setOnClickListener {
            shb1.isVisible = false
            shb1.isClickable = false
        }
        change.setOnClickListener {
            j1 = 1
            startActivity(Intent(this,spisokActivity::class.java))

        }
    }
}