package com.shobu95.android_lifecycle.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shobu95.android_lifecycle.R
import com.shobu95.android_lifecycle.databinding.ActivityMainBinding
import com.shobu95.android_lifecycle.fragments.FirstFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val tag = "lifecycle"
    private lateinit var binding: ActivityMainBinding


    /**
     * Runs first and ONCE when system creates activity
     * Initialize basic stuff here which happens once such as
     * Data/View Binding, Saved State handling, Click Listeners
     * Activity is being created here, hence its not visible
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnOpenActivity.setOnClickListener(this)
        binding.btnOpenFragment.setOnClickListener(this)
        actionBar?.setDisplayShowHomeEnabled(true)
        Log.v(tag, "MainActivity-onCreate Called")
    }

    /**
     * Gets called immediately after onCreate
     * Activity is visible but not interactive/focused
     * Completes very quickly and calls onResume
     * Also gets called after onRestart
     */
    override fun onStart() {
        super.onStart()
        Log.v(tag, "MainActivity-onStart Called")
    }

    /**
     * Always Gets called immediately after onStart
     * Activity is visible and Interactive (Focus)
     * Activity remains focused until revoked by external Intent
     * E.g. PhoneCall, Another activity or system dialog
     * Initialize stuff which needs activity to be on foreground
     * E.g. Camera.
     * Or to initialize stuff released on onPause
     * E.g. broadcast receivers
     */
    override fun onResume() {
        super.onResume()
        Log.v(tag, "MainActivity-onResume Called")
    }

    /**
     * Fires when user leaves the activity (removed from foreground)
     * Activity is partially visible E.g. A system dialog appears
     * Used to release system resources such as sensors,
     * broadcast receivers, camera etc
     * Should not be used for DB operations, network calls, long running
     * processes
     * Calls onResume when returning from system dialog
     * Calls onStop when new activity is launched
     * Or when app is moved to app manager
     */
    override fun onPause() {
        super.onPause()
        Log.v(tag, "MainActivity-onPause Called")
    }


    /**
     * Calls when activity is no longer visible or interactive
     * When a new activity is launched or activity/app is moved to
     * app manager
     * Used to shutdown CPU extensive operations such as
     * Animations and GPS tracking.
     * Best place to save information in DB.
     * Calls onRestart when user return to this activity from
     * another activity or app manager
     * Calls onDestroy when activity is destroyed/finished
     */
    override fun onStop() {
        super.onStop()
        Log.v(tag, "MainActivity-onStop Called")
    }

    /**
     * Called when activity is returning from onStop state
     * always followed by onStart
     */
    override fun onRestart() {
        super.onRestart()
        Log.v(tag, "MainActivity-onRestart Called")
    }

    /**
     * The final lifecycle callback
     * Called when activity is finishing,
     * Or System destroys the activity due to rotation or multi-window
     * Or App removed from App manager
     * Best place to clean-up everything
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "MainActivity-onDestroy Called")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_open_activity -> {
                startActivity(Intent(this, SecondActivity::class.java))
            }
            R.id.btn_open_fragment -> {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.root_layout, FirstFragment())
                    .addToBackStack("firstFragment")
                    .commit()
            }
        }
    }


}