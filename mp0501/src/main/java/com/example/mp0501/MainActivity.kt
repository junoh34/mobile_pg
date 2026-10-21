package com.example.mp0501

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit	var	btObj1: ImageButton
    lateinit	var	btObj2:ImageButton
    lateinit	var	btObj3:ImageButton
    lateinit	var	btObj4:ImageButton
    lateinit	var	ivObj: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btObj1=findViewById(R.id.button1)
        btObj2=findViewById(R.id.button2)
        btObj3=findViewById(R.id.button3)
        btObj4=findViewById(R.id.button4)
        ivObj=findViewById(R.id.imageView2)

        val images = intArrayOf(
            R.drawable.answer1,
            R.drawable.answer2,
            R.drawable.answer3,
            R.drawable.answer4
        )

        var answer = (1..4).random()
        fun check(choice: Int) {
            ivObj.visibility = View.VISIBLE
            ivObj.setImageResource(images[answer - 1])
            if (choice == answer) {
                Toast.makeText(this, "맞았습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
            }
            answer = (1..4).random()
        }

        btObj1.setOnClickListener {
            check(1)
        }
        btObj2.setOnClickListener(View.OnClickListener {
            check(2)
        })
        btObj3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: android.view.View?) {
                check(3)
            }})
        btObj4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: android.view.View?){
                check(4)
            }
        })
    }
}