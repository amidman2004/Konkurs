package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_main7.*
import kotlinx.android.synthetic.main.activity_main7.card
import kotlinx.android.synthetic.main.activity_master.*
import kotlinx.android.synthetic.main.activity_popolnenie_vibor.*
import kotlinx.android.synthetic.main.activity_tipoglavniy.*
import kotlinx.android.synthetic.main.activity_visa.*
import kotlinx.android.synthetic.main.renaming.view.*
import kotlinx.android.synthetic.main.renaming3.view.*
import kotlinx.android.synthetic.main.zablock_layout2.view.*
import kotlinx.android.synthetic.main.zablock_layout2.view.otmn2
import kotlinx.android.synthetic.main.zablock_layout2.view.zblbtn2
import kotlinx.android.synthetic.main.zablock_layout3.view.*

class MasterActivity : AppCompatActivity() {
    var pref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)

        pref = getSharedPreferences("TABLE3", Context.MODE_PRIVATE)
        dame = pref?.getString("dame", "Дебетовая карта")!!
        name3.text = dame

        card.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                startActivity(Intent(this@MasterActivity,MainActivity7::class.java))
            }

            override fun onSwipeRight() {
                startActivity(Intent(this@MasterActivity,VisaActivity::class.java))
            }
        })
        val rr1 = nomer3.text
        val r1 = rr1.replaceRange(
            4,
            8,
            "****"
        )
        nomer3.text = ""
        nomer3.append(r1)

        poses_history3.setOnClickListener {
            startActivity(Intent(this,MasterHistory::class.java))
        }



        zablock3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.zablock_layout3, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmn3.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.zblbtn3.setOnClickListener {
                red3.setTextColor(-0x2100000)
                dialog.dismiss()
                history3.setTextColor(-0x2100000)
                zabl3.setTextColor(-0x2100000)
                rnm3.setTextColor(-0x2100000)
                poses_history3.isClickable = false
                zablock3.isClickable = false
                rename3.isClickable = false

                btn_green3.isClickable = false
                btn_green3.isVisible = false
                btn_red3.isClickable = false
                btn_red3.isVisible = false
            }
        }

        rename3.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout  = inflater.inflate(R.layout.renaming3, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmnizm3.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.izmenitbtn3.setOnClickListener {
                val editor = pref?.edit()
                editor?.putString("dame",dialogLayout.izmenit3.text.toString())
                editor?.apply()
                name3.text = dialogLayout.izmenit3.text.toString()
                dialog.dismiss()

            }

        }

        glavn3.setOnClickListener{
            startActivity(Intent(this, tipoglavniy::class.java))
        }

        btn_red3.setOnClickListener {
            startActivity(Intent(this,popolnitActivity::class.java))
            mir1 = 0
            visa11 = 0
            master111 = 1
            polmir=0
            polvisa=0
            polmaster = 1
        }

        btn_green3.setOnClickListener {
            startActivity(Intent(this,perevestiActivity::class.java))
            permir = 0
            pervisa = 0
            permaster = 1
        }
            plat2.setOnClickListener {
                startActivity(Intent(this, shablonActivity::class.java))
            }


    }
}