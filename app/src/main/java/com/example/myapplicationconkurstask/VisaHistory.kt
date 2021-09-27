package com.example.myapplicationconkurstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_visa_history.*

class VisaHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visa_history)
        plat13.setOnClickListener {
            startActivity(Intent(this, shablonActivity::class.java))
        }
    }
}