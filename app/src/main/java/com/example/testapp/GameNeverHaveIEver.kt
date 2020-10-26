package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.droidnet.DroidListener
import com.droidnet.DroidNet
import kotlinx.android.synthetic.main.activity_game_never_hane_i_ever.*
import kotlinx.android.synthetic.main.game_top_panel.*


class GameNeverHaveIEver : AppCompatActivity(),DroidListener {
    private var mDroidNet: DroidNet = DroidNet.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_never_hane_i_ever)

        title_game.text = resources.getString(R.string.gameNeverHaveIEver) + "..."
        toMainScreenBtn.setOnClickListener {
            finish()
        }

        nextBtn.setOnClickListener {
            nextPhrase()
        }

        mDroidNet.addInternetConnectivityListener(this)
    }

    //set new phrase
    private fun nextPhrase() {
        gameTextView.text = GameManager.nextPhraseForNeverHaveIEver()
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