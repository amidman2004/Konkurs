package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import app.com.kotlinapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main7.*
import kotlinx.android.synthetic.main.activity_main7.card
import kotlinx.android.synthetic.main.activity_master.*
import kotlinx.android.synthetic.main.activity_visa.*
import kotlinx.android.synthetic.main.renaming.*
import kotlinx.android.synthetic.main.renaming.view.*
import kotlinx.android.synthetic.main.zablock_layout.view.*
import kotlin.random.Random

class MainActivity7 : AppCompatActivity() {

    var pref : SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        bame = pref?.getString("bame", "Дебетовая карта")!!
        name.text = bame

        fun SaveData(res: String) {
            val editor = pref?.edit()
            editor?.putString("bame","Дебет")
            editor?.apply()
        }

        card.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                startActivity(Intent(this@MainActivity7,VisaActivity::class.java))

            }

            override fun onSwipeRight() {
                startActivity(Intent(this@MainActivity7,MasterActivity::class.java))

            }
        })

        val rr1 = nomer1.text
        val r1 = rr1.replaceRange(
            4,
            8,
            "****"
        )
        nomer1.text = ""
        nomer1.append(r1)

        poses_history1.setOnClickListener {
            startActivity(Intent(this,MirHistory::class.java))
        }
        zablock1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.zablock_layout, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog=builder.show()

            dialogLayout.otmn.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.zblbtn.setOnClickListener {
            red.setTextColor(-0x2100000)
                dialog.dismiss()
                history1.setTextColor(-0x2100000)
                zabl1.setTextColor(-0x2100000)
                rnm1.setTextColor(-0x2100000)
                poses_history1.isClickable = false
                zablock1.isClickable = false
                rename1.isClickable = false
                btn_green1.isClickable = false
                btn_green1.isVisible = false
                btn_red1.isClickable = false
                btn_red1.isVisible = false
            }
        }


        rename1.setOnClickListener{
        val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout  = inflater.inflate(R.layout.renaming, null)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmnizm.setOnClickListener {
                dialog.dismiss()
            }

            dialogLayout.izmenitbtn.setOnClickListener {

                val editor = pref?.edit()
                editor?.putString("bame",dialogLayout.izmenit.text.toString())
                editor?.apply()
                name.text = dialogLayout.izmenit.text.toString()
                dialog.dismiss()

            }
        }

        glavn1.setOnClickListener{
            startActivity(Intent(this, tipoglavniy::class.java))
        }

btn_red1.setOnClickListener {
    startActivity(Intent(this,popolnitActivity::class.java))
    mir1 = 1
    visa11 = 0
    master111 = 0
    polmir=1
    polvisa=0
    polmaster = 0
}
        btn_green1.setOnClickListener {
        startActivity(Intent(this,perevestiActivity::class.java))
            permir = 1
            pervisa = 0
            permaster = 0
        }

        plat3.setOnClickListener {
            startActivity(Intent(this, shablonActivity::class.java))
        }

    }
}