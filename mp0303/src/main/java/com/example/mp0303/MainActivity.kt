package com.example.mp0303

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var tvNum1 : TextView
    lateinit var tvNum2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvNum1 = findViewById(R.id.num1)
        tvNum2 = findViewById(R.id.num2)
    }

    fun onClickSum(view: View?) {
        val v1 = tvNum1.text.toString().toInt()
        val v2 = tvNum2.text.toString().toInt()
        val sum = v1 + v2
        Toast.makeText(applicationContext, "합계 : $sum", Toast.LENGTH_LONG).show()
    }
}