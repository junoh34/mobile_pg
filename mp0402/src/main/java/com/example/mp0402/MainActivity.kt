package com.example.mp0402

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imgView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgView = findViewById(R.id.imgView)
    }

    fun onClickChoice(view: View?) {
        when (view?.id) {
            R.id.btnImage1 -> Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
            R.id.btnImage2 -> Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_SHORT).show()
            R.id.btnImage3 -> Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}
