package org.geeksforgeeks.checkaux

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mBroadcastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent) {
                val mAction = intent.action
                if (Intent.ACTION_HEADSET_PLUG == mAction) {
                    if (intent.getIntExtra("state", -1) == 0) {
                        Toast.makeText(applicationContext, "AUX not plugged in", Toast.LENGTH_LONG).show()
                    }
                    if (intent.getIntExtra("state", -1) == 1) {
                        Toast.makeText(applicationContext, "AUX plugged in", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        val mReceiverFilter = IntentFilter(Intent.ACTION_HEADSET_PLUG)

        registerReceiver(mBroadcastReceiver, mReceiverFilter)
    }
}