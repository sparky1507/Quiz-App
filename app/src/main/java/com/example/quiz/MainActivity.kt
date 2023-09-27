package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart:Button =findViewById(R.id.btn_start)
        val Editname:EditText =findViewById(R.id.name)

        btnStart.setOnClickListener{
            if(Editname.text.isEmpty()){
                Toast.makeText(this,"Naam toh likh bsdk!",Toast.LENGTH_LONG).show()
            }
            else{
                val intent =Intent(this,quescreen::class.java)
                intent.putExtra(constants.USER_NAME, Editname.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}