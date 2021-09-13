package com.example.myapplicationconkurstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_popolnit.*

class popolnitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popolnit)

        pink11.isVisible=false
        pink11.isClickable=false

        pink12.isVisible=false
        pink12.isClickable=false

        pink13.isVisible=false
        pink13.isClickable=false

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
        }

    }
}