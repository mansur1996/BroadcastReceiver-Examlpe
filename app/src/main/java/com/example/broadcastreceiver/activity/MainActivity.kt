package com.example.broadcastreceiver.activity

import android.app.AlarmManager
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.broadcastreceiver.broadcast_receiver.MyBroadcastReceiver
import com.example.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var myBroadcastReceiver: MyBroadcastReceiver
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myBroadcastReceiver = MyBroadcastReceiver()
    }

    override fun onStart() {
        super.onStart()
        val intentFilterConnection = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        val intentFilterAirplane = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val intentFilterCall = IntentFilter(Intent.ACTION_CALL)


        registerReceiver(myBroadcastReceiver, intentFilterConnection)
        registerReceiver(myBroadcastReceiver, intentFilterAirplane)
        registerReceiver(myBroadcastReceiver, intentFilterCall)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }


}