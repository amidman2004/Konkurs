package com.example.myapplicationconkurstask

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main3.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity3 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val a = LocalDateTime.now()
        val formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        data.text = a.format(formatter2)
        b1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}