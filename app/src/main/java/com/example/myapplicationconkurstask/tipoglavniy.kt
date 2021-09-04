package com.example.myapplicationconkurstask

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_tipoglavniy.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class tipoglavniy : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipoglavniy)

        glavn.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
val timenow = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY")
        credit_text_data.text = timenow.format(formatter)
        credit_text_data1.text = timenow.format(formatter)
        credit_text_data2.text = timenow.format(formatter)
        credit_text_data3.text = timenow.format(formatter)

        val pp = zamena.text
        val p = pp.replaceRange(
            0,
            4,
            "******"
        )
        zamena.text = ""
        zamena.append(p)


        val pp1 = zamena1.text
        val p1 = pp1.replaceRange(
            0,
            4,
            "******"
        )
        zamena1.text = ""
        zamena1.append(p1)

        val pp2 = zamena2.text
        val p2 = pp2.replaceRange(
            0,
            4,
            "******"
        )
        zamena2.text = ""
        zamena2.append(p2)


        val rr = zmn.text
        val r = rr.replaceRange(
            4,
            8,
            "****"
        )
        zmn.text = ""
        zmn.append(r)

        val rr1 = zmn1.text
        val r1 = rr1.replaceRange(
            4,
            8,
            "****"
        )
        zmn1.text = ""
        zmn1.append(r1)

        val rr2 = zmn2.text
        val r2 = rr2.replaceRange(
            4,
            8,
            "****"
        )
        zmn2.text = ""
        zmn2.append(r2)
    }
}