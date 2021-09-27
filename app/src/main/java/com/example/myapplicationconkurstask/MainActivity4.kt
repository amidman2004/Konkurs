package com.example.myapplicationconkurstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_hutorok.view.*
import kotlinx.android.synthetic.main.activity_main4.*

import kotlinx.android.synthetic.main.activity_tipoglavniy.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        parol.setOnClickListener {
            val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.zamena_parola, null)
            val tabl = dialogLayout.findViewById<RelativeLayout>(R.id.zmn)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmena.setOnClickListener {
                dialog.dismiss()
            }

        }
        nazad.setOnClickListener {
            startActivity(Intent(this, tipoglavniy ::class.java))
        }

        lohin.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.zamena_parola, null)
            val tabl1 = dialogLayout.findViewById<RelativeLayout>(R.id.zmnl)
            builder.setView(dialogLayout)
            val dialog: AlertDialog = builder.show()

            dialogLayout.otmena.setOnClickListener {
                dialog.dismiss()
            }

        }

poses_history.setOnClickListener {
startActivity(Intent(this,MainActivity5::class.java))
}
        nazad.setOnClickListener {
            startActivity(Intent(this, tipoglavniy ::class.java))
        }
o_mne.setOnClickListener {
    startActivity(Intent(this, MainActivity6::class.java))
}
        plat0.setOnClickListener {
            startActivity(Intent(this, shablonActivity::class.java))
        }

    }
}