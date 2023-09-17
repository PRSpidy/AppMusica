package com.example.appmusica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var start:Boolean = false
    private var position:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPlay: Button = findViewById(R.id.buttonPlay)
        val buttonPause: Button = findViewById(R.id.buttonPause)

        if(!start){
            changeButtonPosition(buttonPlay, buttonPause, true)
            start = true
        }

        buttonPlay.setOnClickListener{
            changeButtonPosition(buttonPlay, buttonPause, true)
        }

        buttonPause.setOnClickListener{
            changeButtonPosition(buttonPlay, buttonPause, false)
        }

        savedInstanceState?.let {
            position = it.getBoolean("position", false)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("position", position)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        start = savedInstanceState.getBoolean("position", position)
    }

    override fun onResume() {
        super.onResume()
        val buttonPlay: Button = findViewById(R.id.buttonPlay)
        val buttonPause: Button = findViewById(R.id.buttonPause)
        changeButtonPosition(buttonPlay, buttonPause, position);
    }
    private fun changeButtonPosition(buttonPlay: Button, buttonStop: Button, estado: Boolean){
        if(!estado){
            buttonStop.visibility = INVISIBLE
            buttonPlay.visibility = VISIBLE
            position = false;
        }else {
            buttonPlay.visibility = INVISIBLE
            buttonStop.visibility = VISIBLE
            position = true;
        }
    }
}