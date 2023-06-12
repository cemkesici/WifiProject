package com.cem.wifiproject

import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    var modem: WifiManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<View>(R.id.toggleButton) as ToggleButton
        btn.setOnClickListener {
            if (btn.isChecked) {
                wifiAc()
            } else wifiKapat()
        }
    }
    private fun wifiAc() {
        modem = getApplicationContext().getSystemService(WIFI_SERVICE) as WifiManager
        if (modem!!.wifiState == WifiManager.WIFI_STATE_DISABLED) {
            modem!!.isWifiEnabled = true
        } else if (modem!!.wifiState == WifiManager.WIFI_STATE_ENABLING) {
            Toast.makeText(this, "Açık", Toast.LENGTH_SHORT).show()
        }
    }
    private fun wifiKapat() {
        modem = getApplicationContext().getSystemService(WIFI_SERVICE) as WifiManager
        if (modem!!.wifiState == WifiManager.WIFI_STATE_ENABLED) {
            modem!!.isWifiEnabled = false
        } else if (modem!!.wifiState == WifiManager.WIFI_STATE_DISABLING) {
            Toast.makeText(this, "Zaten Kapalı", Toast.LENGTH_SHORT).show()
        }
    }

}