package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)

        val username:TextView=findViewById(R.id.username)
        val score:TextView =findViewById(R.id.score)
        val btn:Button =findViewById(R.id.finish)

        username.text=intent.getStringExtra(constants.USER_NAME)
        val tq: Int =intent.getIntExtra(constants.TOTAL_QUE,0)
        val ca :Int=intent.getIntExtra(constants.CORRECT_ANS,0)
        score.text="Your score is $ca out of $tq"

        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}