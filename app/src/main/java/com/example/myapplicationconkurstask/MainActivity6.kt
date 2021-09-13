package com.example.myapplicationconkurstask

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)


        ssilka.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"))
            startActivity(i)
        }

    }
}