package com.example.myapplicationconkurstask

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_tipoglavniy.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class tipoglavniy : AppCompatActivity() {
    var pref : SharedPreferences? = null
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipoglavniy)

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        bame = pref?.getString("bame", "Дебетовая карта")!!
        val editor = pref?.edit()
        editor?.apply()
        deb_card.text = bame

        pref = getSharedPreferences("TABLE2",Context.MODE_PRIVATE)
        came = pref?.getString("came", "Дебетовая карта")!!
        val editor2 = pref?.edit()
        editor2?.apply()
        visa_card.text = came

        pref = getSharedPreferences("TABLE3",Context.MODE_PRIVATE)
        dame = pref?.getString("dame", "Дебетовая карта")!!
        val editor3 = pref?.edit()
        editor3?.apply()
        visa_card1.text = dame

        pref = getSharedPreferences("TABLE4",Context.MODE_PRIVATE)
        fame = pref?.getString("fame", "Текущий счёт")!!
        val editor4 = pref?.edit()
        editor4?.apply()
        tec_bill.text = fame

        pref = getSharedPreferences("TABLE5",Context.MODE_PRIVATE)
        game = pref?.getString("game", "Текущий счёт")!!
        val editor5 = pref?.edit()
        editor5?.apply()
        tec_bill1.text = game

        pref = getSharedPreferences("TABLE6",Context.MODE_PRIVATE)
        jame = pref?.getString("jame", "Текущий счёт")!!
        val editor6 = pref?.edit()
        editor6?.apply()
        tec_bill2.text = jame


        glavn.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
val timenow = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY")
        credit_text_data.text = timenow.format(formatter)
        credit_text_data1.text = timenow.format(formatter)
        credit_text_data2.text = timenow.format(formatter)
        credit_text_data3.text = timenow.format(formatter)

        vhod.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity4::class.java))
        }
mir_cardRL.setOnClickListener {
    startActivity(Intent(this,MainActivity7::class.java))
}
        visa_cardRL.setOnClickListener {
            startActivity(Intent(this,VisaActivity::class.java))
        }
        visa_cardRL1.setOnClickListener {
            startActivity(Intent(this,MasterActivity::class.java))
        }

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

histr.setOnClickListener {
    startActivity(Intent(this, Poisk::class.java))
}
        bill1RL.setOnClickListener {
            startActivity(Intent(this,schet1::class.java))
        }
        bill2RL.setOnClickListener {
            startActivity(Intent(this,schet2::class.java))
        }
        bill3RL.setOnClickListener {
            startActivity(Intent(this,schet3::class.java))
        }
       plat.setOnClickListener {
           startActivity(Intent(this, shablonActivity::class.java))
       }
    }
}