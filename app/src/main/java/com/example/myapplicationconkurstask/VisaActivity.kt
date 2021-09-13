package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_main7.*
import kotlinx.android.synthetic.main.activity_main7.card
import kotlinx.android.synthetic.main.activity_master.*
import kotlinx.android.synthetic.main.activity_visa.*
import kotlinx.android.synthetic.main.renaming2.*
import kotlinx.android.synthetic.main.renaming2.view.*
import kotlinx.android.synthetic.main.zablock_layout.view.*
import kotlinx.android.synthetic.main.zablock_layout.view.otmn
import kotlinx.android.synthetic.main.zablock_layout.view.zblbtn
import kotlinx.android.synthetic.main.zablock_layout2.view.*

class VisaActivity : AppCompatActivity() {
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visa)

        pref = getSharedPreferences("TABLE2", Context.MODE_PRIVATE)
        came = pref?.getString("came","Дебетовая карта")!!
        name2.text = came



        card.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                startActivity(Intent(this@VisaActivity,MasterActivity::class.java))
            }

            override fun onSwipeRight() {
                startActivity(Intent(this@VisaActivity,MainActivity7::class.java))
            }
        })
        val rr1 = nomer2.text
        val r1 = rr1.replaceRange(
            4,
            8,
            "****"
        )
        nomer2.text = ""
        nomer2.append(r1)

        poses_history2.setOnClickListener {
            startActivity(Intent(this,VisaHistory::class.java))
        }



        zablock2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.zablock_layout2, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmn2.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.zblbtn2.setOnClickListener {
                red2.setTextColor(-0x2100000)
                dialog.dismiss()
                history2.setTextColor(-0x2100000)
                zabl2.setTextColor(-0x2100000)
                rnm2.setTextColor(-0x2100000)
                poses_history2.isClickable = false
                zablock2.isClickable = false
                rename2.isClickable = false
            }}

            rename2.setOnClickListener {
                val builder=AlertDialog.Builder(this)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.renaming2,null)
                builder.setView(dialogLayout)
                val dialog:AlertDialog = builder.show()

                dialogLayout.izmenitbtn2.setOnClickListener{
                    val editor = pref?.edit()
                    editor?.putString("came",dialogLayout.izmenit2.text.toString())
                    editor?.apply()
                    name2.text = dialogLayout.izmenit2.text.toString()
                    dialog.dismiss()

                }
                dialogLayout.otmnizm2.setOnClickListener {
                    dialog.dismiss()
                }

            }
            glavn2.setOnClickListener{
                startActivity(Intent(this, tipoglavniy::class.java))
            }

        }
    }
