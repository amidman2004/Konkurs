package com.example.myapplicationconkurstask

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.InputFilter
import android.util.Log
import android.util.Xml
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.net.ssl.HttpsURLConnection

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    val jobs = SupervisorJob()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        date.text = current.format(formatter)

        white.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
        rlt.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }

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
                scope.launch(Dispatchers.IO) {
                    val user = JSONObject()
                    user.put("login", l1)
                    user.put("pwd", p1)
                    (URL("http://10.0.3.2:3000/login").openConnection() as HttpURLConnection).run {
                        requestMethod = "POST"
                        doOutput = true
                        addRequestProperty("Content-Type", "application/json")
                        val stream = outputStream
                        stream.write(user.toString(0).toByteArray())
                        stream.close()
                        connect()

                        val code = responseCode
                        if (code == 201 || code == 404) {
                            startActivity(Intent(this@MainActivity, tipoglavniy::class.java))
                        }
                    }
                }
            }

            dialogLayout.otmena.setOnClickListener {
                dialog.dismiss()

            }

        }
        msm.setOnClickListener {
        scope.launch(Dispatchers.Default) {
            var i = 0
            i.toString()
            (URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002").openConnection() as HttpURLConnection).run {
                requestMethod = "GET"

                    val response = inputStream.bufferedReader().readText()

                    val dollar = getValute("R01235", response.byteInputStream())

                    val euro = getValute("R01239", response.byteInputStream())
                    EUR_value.text = euro
                    USD_value.text = dollar

            }
        }
    }
}
    val factory = XmlPullParserFactory.newInstance()

    fun getValute(id: String, inputStream: InputStream): String {
        val parser = factory.newPullParser()

        parser.setInput(inputStream, null)
        while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
            parser.next()
            if (parser.eventType == XmlPullParser.START_TAG && parser.name.equals("Valute") && parser.getAttributeValue(
                    0
                ).equals(id)
            ) {
                parser.next()
                while (true) {
                    if (parser.eventType == XmlPullParser.START_TAG && parser.name.equals("Value") ) {
                        parser.next()
                        return parser.text
                    }
                    parser.next()
                }
            }

        }
        return parser.text
    }
}







