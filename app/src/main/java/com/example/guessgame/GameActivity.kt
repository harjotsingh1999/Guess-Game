package com.example.guessgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.guessgame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    lateinit var activityGameBinding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityGameBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(activityGameBinding.root)
    }
}
