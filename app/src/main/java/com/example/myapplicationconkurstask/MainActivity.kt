package com.example.myapplicationconkurstask

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.InputFilter
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import cz.msebera.android.httpclient.client.HttpClient
import cz.msebera.android.httpclient.client.entity.EntityBuilder
import cz.msebera.android.httpclient.client.methods.HttpPost
import cz.msebera.android.httpclient.entity.ContentType
import cz.msebera.android.httpclient.impl.client.HttpClients
import kotlinx.android.synthetic.main.activity_hutorok.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_hutorok.*
import kotlinx.android.synthetic.main.activity_hutorok.view.*
import kotlinx.android.synthetic.main.activity_hutorok.view.voyti
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDateTime
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    private val scope = MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        konopka.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Авторизация")
            builder.setMessage("введите ваш логин и пароль")
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.activity_hutorok, null)
            val editText = dialogLayout.findViewById<RelativeLayout>(R.id.pbt)
            builder.setView(dialogLayout)

            val dialog: AlertDialog = builder.show()

           dialogLayout.voyti.setOnClickListener {
               val log = "login"
               val pwd = "password"
               val l1 = dialogLayout.login.text.toString()
               val p1 = dialogLayout.password.text.toString()

                   startActivity(Intent(this, tipoglavniy::class.java))




           }
            dialogLayout.otmena.setOnClickListener {
                dialog.dismiss()
            }

        }
        }
        }






