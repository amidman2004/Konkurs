package com.example.myapplicationconkurstask

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_popolnenie_vibor.*
import kotlinx.android.synthetic.main.parol.view.*

class popolnenie_vibor : AppCompatActivity() {
    var pref: SharedPreferences? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popolnenie_vibor)

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        bame = pref?.getString("bame", "Дебетовая карта")!!
        val editor1 = pref?.edit()
        editor1?.apply()
        ppl1.text = bame
        ppl11.text = bame

        pref = getSharedPreferences("TABLE2", Context.MODE_PRIVATE)
        came = pref?.getString("came", "Дебетовая карта")!!
        val editor2 = pref?.edit()
        editor2?.apply()
        ppl2.text = came
        ppl12.text = came

        pref = getSharedPreferences("TABLE3", Context.MODE_PRIVATE)
        dame = pref?.getString("dame", "Дебетовая карта")!!
        val editor3 = pref?.edit()
        editor3?.apply()
        ppl3.text = dame
        ppl13.text = dame

        cot1.text = fame
        cot2.text = game
        cot3.text = jame

        vihodd.setOnClickListener {
            startActivity(Intent(this, tipoglavniy::class.java))

            polmir = 0
            otpmir = 0

            polvisa = 0
            otpvisa = 0

            polmaster = 0
            otpmaster = 0

            pol1 = 0
            pol2 = 0
            pol3 = 0
        }
        if (polmir == 1) {
            miiir1.isVisible = true
        }
        if (polvisa == 1) {
            viiisa1.isVisible = true
        }
        if (polmaster == 1) {
            maaaster1.isVisible = true
        }
        if (otpmir == 1) {
            miiir.isVisible = true
        }
        if (otpvisa == 1) {
            viiisa.isVisible = true
        }
        if (otpmaster == 1) {
            maaaster.isVisible = true
        }
        if (pol1 == 1) {
            l1.isVisible = true
        }
        if (pol2 == 1) {
            l2.isVisible = true
        }
        if (pol3 == 1) {
            l3.isVisible = true
        }

            oplatit.setOnClickListener {
                var ss:Int = summa.text.toString().toInt()
                if (ss <= 12000) {
                val builder = AlertDialog.Builder(this)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.parol, null)
                builder.setView(dialogLayout)
                val dialog: AlertDialog = builder.show()

                dialogLayout.otmena1.setOnClickListener {
                    dialog.dismiss()
                }

                dialogLayout.voyti1.setOnClickListener {

                }
            }
                else {
                    Toast.makeText(applicationContext, "Проверьте корректность введённой суммы", Toast.LENGTH_SHORT).show()
        }

        }
    }
}