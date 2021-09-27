package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_spisok.*
import kotlinx.android.synthetic.main.parol.view.*

class spisokActivity : AppCompatActivity() {
    var pref1 : SharedPreferences? = null
    var pref2 : SharedPreferences? = null
    var pref3 : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spisok)
        if (j1 == 1){

            pref1 = getSharedPreferences("SHABLON11", Context.MODE_PRIVATE)
            shablon11 = pref1?.getString("shablon11","shablon11")!!

            pref2 = getSharedPreferences("SHABLON12", Context.MODE_PRIVATE)
            shablon12 = pref2?.getString("shablon12","2")!!
            pref3 = getSharedPreferences("SHABLON13",Context.MODE_PRIVATE)
            shablon13 = pref3?.getString("shablon13","shablon13")!!

            apply.isVisible = true
            apply.isClickable = true
            nomer_dogovora.setText(shablon11)
            spinner.setSelection(shablon12.toInt())
            summ.setText(shablon13)

            apply.setOnClickListener {
                val editor1 = pref1?.edit()
                editor1?.putString("shablon11", nomer_dogovora.text.toString())
                editor1?.apply()

                val current_card = spinner.selectedItemId
                val editor2 = pref2?.edit()
                editor2?.putString("shablon12", current_card.toString())
                editor2?.apply()

                val editor3 = pref3?.edit()
                editor3?.putString("shablon13", summ.text.toString())
                editor3?.apply()
            }
        }
        glan.setOnClickListener {
            startActivity(Intent(this,vse_shabloni::class.java))
        }


        priziv.setOnClickListener {
            if (nomer_dogovora.text.length>0 && summ.text.length>0){
                val builder = AlertDialog.Builder(this)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.parol, null)
                builder.setView(dialogLayout)
                val dialog:AlertDialog = builder.show()

                dialogLayout.otmena1.setOnClickListener {
                    dialog.dismiss()
                }
            }
            else {
                Toast.makeText(applicationContext, "Введите данные", Toast.LENGTH_SHORT).show()
            }

        }
    }
}