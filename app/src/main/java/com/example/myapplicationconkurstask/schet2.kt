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
import kotlinx.android.synthetic.main.activity_schet1.nuzno
import kotlinx.android.synthetic.main.activity_schet2.*
import kotlinx.android.synthetic.main.renaming.view.*
import kotlinx.android.synthetic.main.renaming4.view.*
import kotlinx.android.synthetic.main.renaming5.view.*

class schet2 : AppCompatActivity() {

    var pref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schet2)
        pref = getSharedPreferences("TABLE5", Context.MODE_PRIVATE)
        game = pref?.getString("game", "Текущий счёт")!!
        nuzno2.text = game
        rename5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout  = inflater.inflate(R.layout.renaming5, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmnizm5.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.izmenitbtn5.setOnClickListener {

                val editor = pref?.edit()
                editor?.putString("game",dialogLayout.izmenit5.text.toString())
                editor?.apply()
                nuzno2.text = dialogLayout.izmenit5.text.toString()
                dialog.dismiss()

            }

        }
        glavn5.setOnClickListener{
            startActivity(Intent(this, tipoglavniy::class.java))
        }
        pink2.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                startActivity(Intent(this@schet2,schet3::class.java))

            }

            override fun onSwipeRight() {
                startActivity(Intent(this@schet2,schet1::class.java))

            }
        })

        poses_history5.setOnClickListener {
            startActivity(Intent(this, schet2history::class.java))
        }

    }
}