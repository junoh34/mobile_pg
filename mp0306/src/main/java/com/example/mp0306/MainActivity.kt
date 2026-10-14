package com.example.mp0306

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imgObj : ImageView
    lateinit var numObj: TextView
    var imgNumber = arrayOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5
    )
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgObj = findViewById<ImageView>(R.id.imgViewFg)
        numObj = findViewById<TextView>(R.id.txtViewId)
    }
    fun onBtnNextClick(view: View?) {
        index = (index + 1) % imgNumber.size
        imgObj.setImageResource(imgNumber[index])
        numObj.text = "cat${index+1}.png"
    }
}