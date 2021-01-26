package com.example.musicstore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash
        Thread.sleep(1000)
        setTheme(R.style.MusicStore)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, AuthActivity::class.java))
        finish();

    }
}