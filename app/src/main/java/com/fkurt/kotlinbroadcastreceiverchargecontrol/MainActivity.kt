package com.fkurt.kotlinbroadcastreceiverchargecontrol

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var chargeLevelDetection:ChargeLevelDetection

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chargeLevelDetection=ChargeLevelDetection()
    }

    override fun onResume() {

        val filter=IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")
        registerReceiver(chargeLevelDetection,filter)
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(chargeLevelDetection)
    }
}