package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_schet1.*
import kotlinx.android.synthetic.main.activity_schet2.*
import kotlinx.android.synthetic.main.activity_schet3.*

import kotlinx.android.synthetic.main.renaming5.view.*
import kotlinx.android.synthetic.main.renaming5.view.otmnizm5
import kotlinx.android.synthetic.main.renaming6.view.*

class schet3 : AppCompatActivity() {
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schet3)
        pref = getSharedPreferences("TABLE6", Context.MODE_PRIVATE)
        jame = pref?.getString("jame", "Текущий счёт")!!
        nuzno3.text = jame
        rename6.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout  = inflater.inflate(R.layout.renaming6, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmnizm6.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.izmenitbtn6.setOnClickListener {

                val editor = pref?.edit()
                editor?.putString("jame",dialogLayout.izmenit6.text.toString())
                editor?.apply()
                nuzno3.text = dialogLayout.izmenit6.text.toString()
                dialog.dismiss()

            }

        }
        glavn6.setOnClickListener{
            startActivity(Intent(this, tipoglavniy::class.java))
        }
        pink3.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                startActivity(Intent(this@schet3,schet1::class.java))

            }

            override fun onSwipeRight() {
                startActivity(Intent(this@schet3,schet2::class.java))

            }
        })
        poses_history6.setOnClickListener {
            startActivity(Intent(this, schet3history::class.java))
        }
plat8.setOnClickListener {
    startActivity(Intent(this, shablonActivity::class.java))
}

    }
}