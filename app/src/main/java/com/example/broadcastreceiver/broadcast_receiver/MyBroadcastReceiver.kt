package com.example.broadcastreceiver.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.broadcastreceiver.utils.NetworkHelper

class MyBroadcastReceiver : BroadcastReceiver() {

    private val TAG = "MyBroadcastReceiver"
    // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
    override fun onReceive(context: Context, intent: Intent) {

        /**
         * CONNECTIVITY_ACTION
         */
        val networkHelper = NetworkHelper(context)
        if(networkHelper.isNetworkConnected()){
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onReceive: Connected")
            
        }else{
            Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onReceive: Disconnected")
        }

        /**
         * ACTION_AIRPLANE_MODE_CHANGED
         */

        val isAirplaneModeOn: Boolean = intent.getBooleanExtra("state", false)
        if(isAirplaneModeOn){
            Toast.makeText(context, "AIRPLANE_MODE is ON", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onReceive: AIRPLANE_MODE is ON")
            
        }else{
            Toast.makeText(context, "AIRPLANE_MODE is OFF", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onReceive: AIRPLANE_MODE is OFF")
        }

    }
}