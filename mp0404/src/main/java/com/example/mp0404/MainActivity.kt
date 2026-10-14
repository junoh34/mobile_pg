package com.example.mp0404

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtEdit1: EditText
    lateinit var txtEdit2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtEdit1 = findViewById(R.id.txtEdit1)
        txtEdit2 = findViewById(R.id.txtEdit2)
    }

    fun onClickResult(view: View?) {
        val partA = txtEdit1.text.toString().toInt()
        val partB = txtEdit2.text.toString().toInt()

        if (partA == 2 && partB == 5) Toast.makeText(applicationContext,"맞았습니다.", Toast.LENGTH_SHORT).show()
        else Toast.makeText(applicationContext,"틀렸습니다.", Toast.LENGTH_SHORT).show()
    }
}