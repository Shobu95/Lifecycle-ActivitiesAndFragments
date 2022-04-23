package com.shobu95.android_lifecycle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shobu95.android_lifecycle.R

class SecondActivity : AppCompatActivity() {
    private val tag = "lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.v(tag, "SecondActivity-onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        Log.v(tag, "SecondActivity-onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "SecondActivity-onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag, "SecondActivity-onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "SecondActivity-onStop Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(tag, "SecondActivity-onRestart Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "SecondActivity-onDestroy Called")
    }
}