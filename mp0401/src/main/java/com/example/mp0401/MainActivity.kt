package com.example.mp0401

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imgView1: ImageView
    lateinit var imgView2: ImageView
    lateinit var txtEditR: EditText
    var diceNumber = intArrayOf(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6,
    )
    var num1 = 0
    var num2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgView1 = findViewById(R.id.imgView1)
        imgView2 = findViewById(R.id.imgView2)
        txtEditR = findViewById(R.id.txtEdit)

        num1 = (1..6).random()
        num2 = (1..6).random()
        imgView1.setImageResource(diceNumber[num1 - 1])
        imgView2.setImageResource(diceNumber[num2 - 1])
    }

    fun onClickChoice(view: View?) {
        val inputStr = txtEditR.text.toString()
        val num = inputStr.toIntOrNull()
        if (num == null) {
            Toast.makeText(applicationContext, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show()
            return
        }
        if (num == num1 + num2) {
            Toast.makeText(applicationContext, "맞았습니다.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "틀렸습니다.", Toast.LENGTH_LONG).show()
        }
    }

    fun onClickSuffle(view: View?) {
        num1 = (1..6).random()
        num2 = (1..6).random()
        imgView1.setImageResource(diceNumber[num1 - 1])
        imgView2.setImageResource(diceNumber[num2 - 1])
        txtEditR.setText("")
    }
}
