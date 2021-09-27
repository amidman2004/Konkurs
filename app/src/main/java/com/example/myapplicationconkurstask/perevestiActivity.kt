package com.example.myapplicationconkurstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_perevesti.*
import kotlinx.android.synthetic.main.parol.view.*

class perevestiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perevesti)
        ame11.text = bame
        ame12.text = came
        ame13.text = dame
        if(permir == 1){
            ard11.isClickable = false
            ard11.isVisible = false
        }
        if(pervisa == 1){
            ard12.isClickable = false
            ard12.isVisible = false
        }
        if(permaster == 1){
            ard13.isClickable = false
            ard13.isVisible = false
        }
        lavn14.setOnClickListener {
            startActivity(Intent(this,tipoglavniy::class.java))
        }

        ihod.setOnClickListener {
            startActivity(Intent(this,tipoglavniy::class.java))
        }
        ard11.setOnClickListener {
            startActivity(Intent(this,perevesti2Activity::class.java))
            mir2 = 1
            visa2 = 0
            master2 = 0
        }
        ard12.setOnClickListener {
            startActivity(Intent(this,perevesti2Activity::class.java))
            mir2 =0
            visa2 = 1
            master2 = 0
        }
        ard13.setOnClickListener {
            startActivity(Intent(this,perevesti2Activity::class.java))
            mir2 =0
            visa2 = 0
            master2 = 1

        }
        plat15.setOnClickListener {
            startActivity(Intent(this, shablonActivity::class.java))
        }
    }
}