package com.example.myapplicationconkurstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_shablon.*
import kotlinx.android.synthetic.main.renaming.*
import kotlinx.android.synthetic.main.vse_shabloni.*

class shablonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shablon)


        i.setOnClickListener{
            startActivity(Intent(this,spisokActivity::class.java))
        }
        perehod.setOnClickListener {
            startActivity(Intent(this,vse_shabloni::class.java))
        }


        }
    }
