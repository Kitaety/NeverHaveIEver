package com.example.testapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidnet.DroidListener
import com.droidnet.DroidNet
import kotlinx.android.synthetic.main.main_activity_content.*

class MainActivity() : AppCompatActivity(),DroidListener  {
    private var mDroidNet:DroidNet = DroidNet.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_game_never_have_i_ever.setOnClickListener {
            mDroidNet.removeInternetConnectivityChangeListener(this)
            val intent = Intent(this,GameNeverHaveIEver::class.java)
            startActivity(intent)
        }
        button_game_truth_or_dare.setOnClickListener {
            mDroidNet.removeInternetConnectivityChangeListener(this)
            val intent = Intent(this,GameTruthOrDare::class.java)
            startActivity(intent)
        }

        mDroidNet.addInternetConnectivityListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDroidNet.removeInternetConnectivityChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        mDroidNet.removeInternetConnectivityChangeListener(this)
        mDroidNet.addInternetConnectivityListener(this)
    }
    override fun onInternetConnectivityChanged(isConnected: Boolean) {
        if(!isConnected && !NotInternetFragment.isOpen()){
            NotInternetFragment.show(supportFragmentManager)
        }else if(NotInternetFragment.isOpen()){
            NotInternetFragment.close()
        }
    }
}