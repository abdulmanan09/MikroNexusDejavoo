package com.mikronexus.dejavoo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var button: MaterialButton
    lateinit var textView: TextView
    lateinit var dateTime: TextView
    lateinit var calendar: Calendar
    lateinit var dateFormat: SimpleDateFormat
    private var date: String? = null

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.proceed)
        textView = findViewById(R.id.packageName)
        dateTime = findViewById(R.id.dateTime)
        //----------------Set Date Time
        calendar = Calendar.getInstance()
        dateFormat = SimpleDateFormat("MM-dd-yyyy HH:mm:ss")
        date = dateFormat.format(calendar.time)
        dateTime.text = date


        textView.text = "" + packageName
        button.setOnClickListener {
            var i = Intent(Intent.ACTION_MAIN)
            val managerclock = packageManager
            if (managerclock.getLaunchIntentForPackage("com.mikronexus.cfa") != null) {
                i = managerclock.getLaunchIntentForPackage("com.mikronexus.cfa")!!
                i.addCategory(Intent.CATEGORY_LAUNCHER)
                startActivity(i)
            } else {
                Toast.makeText(
                    this, "Please Install the other Application to Switch", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}