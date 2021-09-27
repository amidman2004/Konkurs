package com.example.myapplicationconkurstask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_perevesti.*
import kotlinx.android.synthetic.main.activity_pervesti2.*
import kotlinx.android.synthetic.main.activity_popolnenie_vibor.*
import kotlinx.android.synthetic.main.parol.view.*

class perevesti2Activity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pervesti2)
        pl1.text = bame
        pl11.text = bame

        pl2.text = came
        pl12.text = came

        pl3.text = dame
        pl13.text = dame
        if(permir == 1){
            miir.isVisible = true
        }
        if(pervisa == 1){
            viisa.isVisible = true
        }
        if(permaster == 1){
            maaster.isVisible = true
        }
        if (mir2 == 1){
            miir1.isVisible = true
        }
        if (visa2 == 1){
            viisa1.isVisible = true
        }
        if (master2 == 1){
            maaster1.isVisible = true
        }


        oplatit1.setOnClickListener {
            var ss:Int = summa1.text.toString().toInt()
            if (summa1.text.length>0 && ss <= 12000) {
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