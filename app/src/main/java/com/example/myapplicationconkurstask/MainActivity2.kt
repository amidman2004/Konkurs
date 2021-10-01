package com.example.myapplicationconkurstask

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.view.size
import com.example.myapplicationconkurstask.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity2 : AppCompatActivity(), OnMapReadyCallback {

    fun getJson(timeO:TextView, adress: TextView, response:String, tag:Int){
        val developerArray = JSONArray(response) //   Преобразует данные ответа в массив JSON
            // Get single JSON object node
            val mItemObject: JSONObject = developerArray.getJSONObject(tag)
            // Get String value from json object
            val parsed = mItemObject.getString("name")
            val timeOt =mItemObject.getString("time_from")
        val timeDo = mItemObject.getString("time_to")
            adress.text = parsed
        val formatter = SimpleDateFormat("hh:mm")
        var time1 = formatter.format(Date(timeOt.toLong()))
        var time2 = formatter.format(Date(timeDo.toLong()))
            timeO.text = "$time1 - $time2"
    }

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

scope.launch(Dispatchers.IO) {
    (URL("http://10.0.3.2:3000/bankomats").openConnection() as HttpURLConnection).run {
        requestMethod = "GET"
        doInput = true
        connect()
        val stream = inputStream
        val response = stream.bufferedReader().readText()
        for(i in 0 until  sp.size){
            getJson((sp.getChildAt(i) as RelativeLayout).getChildAt(4) as TextView,(sp.getChildAt(i) as RelativeLayout).getChildAt(0) as TextView, response, i)
        }

    }
}








        b1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)



        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH")
        vremanow.text = current.format(formatter)
        val a: Int = vremanow.text.toString().toInt()
        if (a < 9) {
            t1.setText("Закрыто")
            t1.setTextColor(-0x2100000)
        }



        vremanow1.text = current.format(formatter)
        val a1: Int = vremanow1.text.toString().toInt()
        if (a1 < 9) {
            t11.setText("Закрыто")
            t11.setTextColor(-0x2100000)
        }


        vremanow11.text = current.format(formatter)
        val a11: Int = vremanow11.text.toString().toInt()
        if (a11 < 9) {
            t111.setText("Закрыто")
            t111.setTextColor(-0x2100000)
        }


        vremanow111.text = current.format(formatter)
        val a111: Int = vremanow111.text.toString().toInt()
        if (a111 < 9) {
            t1111.setText("Закрыто")
            t1111.setTextColor(-0x2100000)
        }


        vremanow1111.text = current.format(formatter)
        val a1111: Int = vremanow1111.text.toString().toInt()
        if (a1111 < 9) {
            t11111.setText("Закрыто")
            t11111.setTextColor(-0x2100000)
        }


        vremanow11111.text = current.format(formatter)
        val a11111: Int = vremanow11111.text.toString().toInt()
        if (a11111 < 9) {
            t111111.setText("Закрыто")
            t111111.setTextColor(-0x2100000)
        }


        vremanow111111.text = current.format(formatter)
        val a111111: Int = vremanow111111.text.toString().toInt()
        if (a111111 < 9) {
            t1111111.setText("Закрыто")
            t1111111.setTextColor(-0x2100000)
        }
    }
     override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this@MainActivity2)
        setUpMap()
        c1.setOnClickListener {
            val zavodic = LatLng( 53.205754, 50.275634)
            mMap.addMarker(
                MarkerOptions()
                .position(zavodic).title("ZAVOD")
                .snippet("НА ЗАВОД"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(zavodic, 12f))
        }
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                MapsActivity.LOCATION_REQUEST_CODE
            )
            return
        }
        mMap.isMyLocationEnabled = true
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->

            if (location != null){
                lastLocation = location
                val currentLatLong = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLong)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 12f))
            }
        }
    }

    private fun placeMarkerOnMap(currentLatLong: LatLng) {
        val markerOptions = MarkerOptions().position(currentLatLong)
        markerOptions.title("$currentLatLong")
        mMap.addMarker(markerOptions)

    }

    fun onMarkerClick(p0: Marker?) = false
    private fun SupportMapFragment.getMapAsync(mainActivity2: MainActivity2) = false
    private fun GoogleMap.setOnMarkerClickListener(mainActivity2: MainActivity2)  = false
        }











