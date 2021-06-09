package com.example.myapplicationconkurstask

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextClock
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.timepicker.TimeFormat
import kotlinx.android.synthetic.main.activity_main2.*
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        b1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH")
        vremanow.text = current.format(formatter)
        val a: Int = vremanow.text.toString().toInt()
        if (a < 9) {
            t1.setText("Закрыто")
            t1.setTextColor(-0x2100000)
        }



        vremanow1.text = current.format(formatter)
        val a1: Int = vremanow1.text.toString().toInt()
        if (a1 < 9) {
            t11.setText("Закрыто")
            t11.setTextColor(-0x2100000)
        }


        vremanow11.text = current.format(formatter)
        val a11: Int = vremanow11.text.toString().toInt()
        if (a11 < 9) {
            t111.setText("Закрыто")
            t111.setTextColor(-0x2100000)
        }


        vremanow111.text = current.format(formatter)
        val a111: Int = vremanow111.text.toString().toInt()
        if (a111 < 9) {
            t1111.setText("Закрыто")
            t1111.setTextColor(-0x2100000)
        }


        vremanow1111.text = current.format(formatter)
        val a1111: Int = vremanow1111.text.toString().toInt()
        if (a1111 < 9) {
            t11111.setText("Закрыто")
            t11111.setTextColor(-0x2100000)
        }


        vremanow11111.text = current.format(formatter)
        val a11111: Int = vremanow11111.text.toString().toInt()
        if (a11111 < 9) {
            t111111.setText("Закрыто")
            t111111.setTextColor(-0x2100000)
        }


        vremanow111111.text = current.format(formatter)
        val a111111: Int = vremanow111111.text.toString().toInt()
        if (a111111 < 9) {
            t1111111.setText("Закрыто")
            t1111111.setTextColor(-0x2100000)
        }


    }
        }







