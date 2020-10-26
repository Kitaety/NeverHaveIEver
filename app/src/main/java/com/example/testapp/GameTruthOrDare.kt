package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droidnet.DroidListener
import com.droidnet.DroidNet
import kotlinx.android.synthetic.main.activity_game_trurh_or_dare.*
import kotlinx.android.synthetic.main.game_top_panel.*

class GameTruthOrDare : AppCompatActivity(), DroidListener {
    private var mDroidNet: DroidNet = DroidNet.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_trurh_or_dare)

        title_game.text = resources.getString(R.string.gameTruthOrDare)

        toMainScreenBtn.setOnClickListener {
            finish()
        }
        truthBtn.setOnClickListener {
            nextPhrase(0)
        }
        dareBtn.setOnClickListener {
            nextPhrase(1)
        }
        mDroidNet.addInternetConnectivityListener(this)
    }

    //set new phrase
    private fun nextPhrase(code:Int) {
        if(code == 0){
            gameTextView.text = GameManager.nextPhraseTruth()
        }else{
            gameTextView.text = GameManager.nextPhraseDare()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mDroidNet.removeInternetConnectivityChangeListener(this)
    }

    override fun onInternetConnectivityChanged(isConnected: Boolean) {
        if(!isConnected && !NotInternetFragment.isOpen()){
            NotInternetFragment.show(supportFragmentManager)
        }else if(NotInternetFragment.isOpen()){
            NotInternetFragment.close()
        }
    }
}