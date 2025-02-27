package com.humber.customviewlab

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.ComponentActivity
//import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressView = findViewById<CircularProgressView>(R.id.progressView)
        val seekBar = findViewById<SeekBar>(R.id.progressSeekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressView.setProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}