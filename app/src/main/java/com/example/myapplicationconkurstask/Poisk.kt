package com.example.myapplicationconkurstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.android.synthetic.main.activity_poisk.*

class Poisk : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poisk)
        fun check(vararg cells: TextView){

            cells.forEach {
                var a = ET1.text.toString()
                if (it.text ==a){
                    it.isVisible=true
                }
                else{
                    it.isVisible=false
                }
            }
        }
        vh.setOnClickListener {
            var a = ET1.text.toString()
            if (te2.text ==a){
                te2.isVisible=true
            }
            else{
                te2.isVisible=false
            }
            check(te2,te3,te4,te5,te6,te7,te8)
        }
    }
}