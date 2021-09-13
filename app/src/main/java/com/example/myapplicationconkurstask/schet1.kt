package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_main7.*
import kotlinx.android.synthetic.main.activity_schet1.*
import kotlinx.android.synthetic.main.renaming.view.*
import kotlinx.android.synthetic.main.renaming4.view.*

class schet1 : AppCompatActivity() {

    var pref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schet1)
        pref = getSharedPreferences("TABLE4", Context.MODE_PRIVATE)
        fame = pref?.getString("fame", "Дебетовая карта")!!
        nuzno.text = fame
        rename4.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout  = inflater.inflate(R.layout.renaming4, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmnizm4.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.izmenitbtn4.setOnClickListener {

                val editor = pref?.edit()
                editor?.putString("fame",dialogLayout.izmenit4.text.toString())
                editor?.apply()
                nuzno.text = dialogLayout.izmenit4.text.toString()
                dialog.dismiss()

            }


        }
        glavn4.setOnClickListener{
            startActivity(Intent(this, tipoglavniy::class.java))
        }
        pink.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                startActivity(Intent(this@schet1,schet2::class.java))
            }
            override fun onSwipeRight() {
                startActivity(Intent(this@schet1,schet3::class.java))

            }
        })
        poses_history4.setOnClickListener {
            startActivity(Intent(this, schet1history::class.java))
        }
    }
}