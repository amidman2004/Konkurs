package com.example.myapplicationconkurstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lje_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lje)
        startActivity(Intent(this,MainActivity7::class.java))
    }
}