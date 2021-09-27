package com.example.myapplicationconkurstask

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_popolnit.*
import kotlinx.android.synthetic.main.activity_popolnit.vihod
import kotlinx.android.synthetic.main.activity_tipoglavniy.*

class popolnitActivity : AppCompatActivity() {
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popolnit)

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        bame = pref?.getString("bame", "Дебетовая карта")!!
        val editor = pref?.edit()
        editor?.apply()
        name11.text = bame

        pref = getSharedPreferences("TABLE2", Context.MODE_PRIVATE)
        came = pref?.getString("came", "Дебетовая карта")!!
        val editor2 = pref?.edit()
        editor2?.apply()
        name12.text = came

        pref = getSharedPreferences("TABLE3", Context.MODE_PRIVATE)
        dame = pref?.getString("dame", "Дебетовая карта")!!
        val editor3 = pref?.edit()
        editor3?.apply()
        name13.text = dame

        pref = getSharedPreferences("TABLE4",Context.MODE_PRIVATE)
        fame = pref?.getString("fame", "Текущий счёт")!!
        val editor4 = pref?.edit()
        editor4?.apply()
        nuzno11.text = fame

        pref = getSharedPreferences("TABLE5",Context.MODE_PRIVATE)
        game = pref?.getString("game", "Текущий счёт")!!
        val editor5 = pref?.edit()
        editor5?.apply()
        nuzno12.text = game

        pref = getSharedPreferences("TABLE6",Context.MODE_PRIVATE)
        jame = pref?.getString("jame", "Текущий счёт")!!
        val editor6 = pref?.edit()
        editor6?.apply()
        nuzno13.text = jame

        pink11.isVisible=false
        pink11.isClickable=false

        pink12.isVisible=false
        pink12.isClickable=false

        pink13.isVisible=false
        pink13.isClickable=false




            if (mir1 == 1) {
            card11.isClickable = false
                card11.isVisible= false
            }

        if (visa11 == 1) {
            card12.isClickable = false
            card12.isVisible= false
        }

        if (master111 == 1) {
            card13.isClickable = false
            card13.isVisible= false
        }

        s_carti.setOnClickListener{
            so_scheta.setTextColor(4279311871.toInt())
            so_scheta.setBackgroundColor(4294967295.toInt())
            s_carti.setBackgroundColor(4279311871.toInt())
            s_carti.setTextColor(4294967295.toInt())

            card11.isVisible=true
            card11.isClickable=true

            card12.isVisible=true
            card12.isClickable=true

            card13.isVisible=true
            card13.isClickable=true

            pink11.isVisible=false
            pink11.isClickable=false

            pink12.isVisible=false
            pink12.isClickable=false

            pink13.isVisible=false
            pink13.isClickable=false

            if (mir1 == 1) {
                card11.isClickable = false
                card11.isVisible= false
            }

            if (visa11 == 1) {
                card12.isClickable = false
                card12.isVisible= false
            }

            if (master111 == 1) {
                card13.isClickable = false
                card13.isVisible= false
            }
        }

        so_scheta.setOnClickListener{
            s_carti.setTextColor(4279311871.toInt())
            s_carti.setBackgroundColor(4294967295.toInt())
            so_scheta.setBackgroundColor(4279311871.toInt())
            so_scheta.setTextColor(4294967295.toInt())
            card11.isVisible=false
            card11.isClickable=false

            card12.isVisible=false
            card12.isClickable=false

            card13.isVisible=false
            card13.isClickable=false

            pink11.isVisible=true
            pink11.isClickable=true

            pink12.isVisible=true
            pink12.isClickable=true

            pink13.isVisible=true
            pink13.isClickable=true

            if (mir1 == 1) {
                card11.isClickable = false
                card11.isVisible= false
            }

            if (visa11 == 1) {
                card12.isClickable = false
                card12.isVisible = false
            }

            if (master111 == 1) {
                card13.isClickable = false
                card13.isVisible= false
            }
        }
        vihod.setOnClickListener{
            startActivity(Intent(this,tipoglavniy::class.java))
            mir1 = 0
            visa11 = 0
            master111 = 0
            pol1 = 0
            pol2 = 0
            pol3 = 0
        }

        glavn14.setOnClickListener{
            startActivity(Intent(this,tipoglavniy::class.java))
            mir1 = 0
            visa11 = 0
            master111 = 0
            pol1 = 0
            pol2 = 0
            pol3 = 0
        }


        card11.setOnClickListener{
        startActivity(Intent(this,popolnenie_vibor::class.java))
            otpmir = 1
            otpvisa = 0
            otpmaster = 0
            pol1 = 0
            pol2 = 0
            pol3 = 0
        }

        card12.setOnClickListener{
            startActivity(Intent(this,popolnenie_vibor::class.java))
            otpmir = 0
            otpvisa = 1
            otpmaster = 0
            pol1 = 0
            pol2 = 0
            pol3 = 0
        }

        card13.setOnClickListener{
            startActivity(Intent(this,popolnenie_vibor::class.java))
            otpmir = 0
            otpvisa = 0
            otpmaster = 1
            pol1 = 0
            pol2 = 0
            pol3 = 0
        }

        pink11.setOnClickListener {
            startActivity(Intent(this,popolnenie_vibor::class.java))
            pol1 = 1
            pol2 = 0
            pol3 = 0
            otpmir = 0
            otpvisa = 0
            otpmaster = 0
        }

        pink12.setOnClickListener {
            startActivity(Intent(this,popolnenie_vibor::class.java))
            pol1 = 0
            pol2 = 1
            pol3 = 0
            otpmir = 0
            otpvisa = 0
            otpmaster = 0
        }

        pink13.setOnClickListener {
            startActivity(Intent(this,popolnenie_vibor::class.java))
            pol1 = 0
            pol2 = 0
            pol3 = 1
            otpmir = 0
            otpvisa = 0
            otpmaster = 0
        }
        plat16.setOnClickListener {
            startActivity(Intent(this, shablonActivity::class.java))
        }

    }
}